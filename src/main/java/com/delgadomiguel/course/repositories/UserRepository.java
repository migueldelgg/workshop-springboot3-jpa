package com.delgadomiguel.course.repositories;

import com.delgadomiguel.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long > {

    //Nao preciso criar implementações, pois,
    // estou passando minha entidade como o tipo genérico e
    // o spring data jpa já tem implementações as necessárias

}
