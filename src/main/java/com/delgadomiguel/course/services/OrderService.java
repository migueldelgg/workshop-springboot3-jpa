package com.delgadomiguel.course.services;

import com.delgadomiguel.course.entities.Order;
import com.delgadomiguel.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository OrderRepository;

    public List<Order> findAll() {
        return OrderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = OrderRepository.findById(id);
        return obj.get(); //
    }

}
