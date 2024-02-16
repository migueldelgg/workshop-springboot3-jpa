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

@RestController // Indica que essa classe é um controller REST
@RequestMapping(value = "/orders") // Define o caminho base para todas as URLs mapeadas por este controlador
public class OrderResource {

    @Autowired // Indica que a instância do OrderService será injetada automaticamente pelo Spring
    private OrderService orderService;

    @GetMapping // Mapeia requisições GET para o caminho base ("/orders") para este método
    public ResponseEntity<List<Order>> findAll() { // Retorna uma lista de pedidos em resposta a uma solicitação GET
        List<Order> list = orderService.findAll(); // Obtém a lista de pedidos do serviço
        return ResponseEntity.ok().body(list); // Retorna a lista de pedidos na resposta HTTP com status 200 OK
    }

    @GetMapping(value = "/{id}") // Mapeia requisições GET para ("/orders/{id}") para este método
    public ResponseEntity<Order> findById(@PathVariable Long id) { // Retorna um pedido com o ID especificado em resposta a uma solicitação GET
        Order obj = orderService.findById(id); // Obtém o pedido com o ID especificado do serviço
        return ResponseEntity.ok().body(obj); // Retorna o pedido na resposta HTTP com status 200 OK
    }
}
