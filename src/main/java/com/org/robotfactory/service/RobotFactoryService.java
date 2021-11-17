package com.org.robotfactory.service;

import com.org.robotfactory.exception.NonUniquePartException;
import com.org.robotfactory.model.*;
import com.org.robotfactory.model.*;
import com.org.robotfactory.repository.OrderRepository;
import com.org.robotfactory.repository.PartRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

@Service
public class RobotFactoryService {

    @Autowired
    PartRepository partRepository;

    @Autowired
    OrderRepository orderRepository;

    public OrderResponse orderRobot(OrderRequest request) {

        validateRequest(request.getComponents());

        checkOrderStock(request);

        BigDecimal totalPrice = calculatePriceAndReduceStock(request);

        OrderResponse response = saveOrder(request, totalPrice);

        return response;
    }

    @NotNull
    private OrderResponse saveOrder(OrderRequest request, BigDecimal totalPrice) {
        OrderResponse response = new OrderResponse();
        response.setOrderId(UUID.randomUUID().toString());
        response.setTotalPrice(getTotalPrice(totalPrice));
        orderRepository.add(new Order(response.getOrderId(), request.getComponents(), getTotalPrice(totalPrice)));
        return response;
    }

    public List<Order> getOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    private BigDecimal calculatePriceAndReduceStock(OrderRequest request) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (String componentCode : request.getComponents()) {
            partRepository.reduceStockByOne(componentCode);
            Part part = partRepository.findByCode(componentCode);
            totalPrice = totalPrice.add(part.getPrice());
        }
        return totalPrice;
    }

    private void checkOrderStock(OrderRequest request) {
        request.getComponents().forEach(partRepository::checkStockByCode);
    }

    private BigDecimal getTotalPrice(BigDecimal totalPrice) {
        return totalPrice.setScale(2, RoundingMode.HALF_UP);
    }

    private void validateRequest(List<String> orderParts) {
        int armCount = 0;
        int faceCount = 0;
        int materialCount = 0;
        int mobilityCount = 0;
        List<Part> parts = partRepository.findByCodeList(orderParts);
        for (Part part : parts) {
            if (part instanceof FacePart) {
                faceCount++;
            } else if (part instanceof ArmPart) {
                armCount++;
            } else if (part instanceof MaterialPart) {
                materialCount++;
            } else if (part instanceof MobilityPart) {
                mobilityCount++;
            }
        }
        if (armCount != 1 || faceCount != 1 || materialCount != 1 || mobilityCount != 1) {
            throw new NonUniquePartException("You must have each robot part once in your request!");
        }
    }
}
