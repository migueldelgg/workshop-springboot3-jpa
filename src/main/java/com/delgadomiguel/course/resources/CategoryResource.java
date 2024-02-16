package com.delgadomiguel.course.resources;

import com.delgadomiguel.course.entities.Category;
import com.delgadomiguel.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // Isso significa que a requisição vai aceitar um parâmetro na url, nesse caso um Id
    public ResponseEntity<Category> findById (@PathVariable Long id) { //PathVariable serve para aceitar o parâmetro da url como parâmetro no método
        Category obj = categoryService.findById(id);

        return ResponseEntity.ok().body(obj);
    }

}
