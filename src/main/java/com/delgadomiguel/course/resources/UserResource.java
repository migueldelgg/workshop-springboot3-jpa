package com.delgadomiguel.course.resources;

import com.delgadomiguel.course.entities.User;
import com.delgadomiguel.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // Isso significa que a requisição vai aceitar um parâmetro na url, nesse caso um Id
    public ResponseEntity<User> findById(@PathVariable Long id){ //PathVariable serve para aceitar o parâmetro da url como parâmetro no método
        User obj = userService.findById(id);

        return ResponseEntity.ok().body(obj);
    }

}
