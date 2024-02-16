package com.delgadomiguel.course.resources;

import com.delgadomiguel.course.entities.Product;
import com.delgadomiguel.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = productService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // Isso significa que a requisição vai aceitar um parâmetro na url, nesse caso um Id
    public ResponseEntity<Product> findById(@PathVariable Long id) { //PathVariable serve para aceitar o parâmetro da url como parâmetro no método
        Product obj = productService.findById(id);

        return ResponseEntity.ok().body(obj);
    }

}
