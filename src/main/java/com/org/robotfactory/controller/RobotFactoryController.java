package com.org.robotfactory.controller;

import com.org.robotfactory.model.Order;
import com.org.robotfactory.model.OrderRequest;
import com.org.robotfactory.model.OrderResponse;
import com.org.robotfactory.service.RobotFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class RobotFactoryController {

    @Autowired
    RobotFactoryService robotFactoryService;

    @RequestMapping(value = "/orders", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getBoards(@RequestBody OrderRequest request) {
        OrderResponse response = robotFactoryService.orderRobot(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getBoards() {
        List<Order> response = robotFactoryService.getOrders();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
