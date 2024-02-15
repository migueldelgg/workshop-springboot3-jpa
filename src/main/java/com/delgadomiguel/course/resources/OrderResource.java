package com.delgadomiguel.course.resources;

import com.delgadomiguel.course.entities.Order;
import com.delgadomiguel.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // Isso significa que a requisição vai aceitar um parâmetro na url, nesse caso um Id
    public ResponseEntity<Order> findById(@PathVariable Long id) { //PathVariable serve para aceitar o parâmetro da url como parâmetro no método
        Order obj = orderService.findById(id);

        return ResponseEntity.ok().body(obj);
    }

}
