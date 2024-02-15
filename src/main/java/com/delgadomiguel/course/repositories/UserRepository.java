package com.delgadomiguel.course.repositories;

import com.delgadomiguel.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long > {

    //Não preciso criar implementações, pois
    // estou passando minha entidade como o tipo genérico e
    // o Spring Data JPA já fornece as implementações necessárias.

    //Também não é necessário colocar o @Repository para realizarmos a injeção de dependência
    // automática, pois o JpaRepository, a interface que estamos estendendo,
    // já é registrada como componente pelo proprio Spring.

}
