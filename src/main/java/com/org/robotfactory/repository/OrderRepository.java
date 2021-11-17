package com.org.robotfactory.repository;

import com.org.robotfactory.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class OrderRepository {
    private static ConcurrentHashMap<String, Order> orderStorage = new ConcurrentHashMap<>();

    public Order add(Order order) {
        orderStorage.put(order.getId(), order);

        return order;
    }

    public Order delete(String id) {
        Order p = orderStorage.get(id);
        orderStorage.remove(id);

        return p;
    }

    public Order findById(String id) {
        return orderStorage.get(id);
    }

    public List<Order> findAll() {
        return orderStorage
                .values()
                .stream()
                .collect(Collectors.toList());
    }
}
