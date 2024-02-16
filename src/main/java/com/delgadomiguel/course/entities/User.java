package com.delgadomiguel.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_user") // "User" é uma palavra reservada no banco de dados H2
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // Identifica este atributo como a chave primária do banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) // A estratégia de geração de valor para a chave primária
    private Long id; // Valor gerado sequencialmente

    private String name;
    private String email;
    private String phone;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    // Um cliente pode ter muitos pedidos, mapeado pelo atributo "client" na classe Order
    private List<Order> orders = new ArrayList<>(); // Não criamos método setter para coleções

    public User() {
    }

    // Construtor com todos os atributos
    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    // Getters e Setters

    // Retorna o ID do usuário
    public Long getId() {
        return id;
    }

    // Define o ID do usuário
    public void setId(Long id) {
        this.id = id;
    }

    // Retorna o nome do usuário
    public String getName() {
        return name;
    }

    // Define o nome do usuário
    public void setName(String name) {
        this.name = name;
    }

    // Retorna o e-mail do usuário
    public String getEmail() {
        return email;
    }

    // Define o e-mail do usuário
    public void setEmail(String email) {
        this.email = email;
    }

    // Retorna o telefone do usuário
    public String getPhone() {
        return phone;
    }

    // Define o telefone do usuário
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Retorna a senha do usuário
    public String getPassword() {
        return password;
    }

    // Define a senha do usuário
    public void setPassword(String password) {
        this.password = password;
    }

    // Retorna a lista de pedidos associados ao usuário
    public List<Order> getOrders() {
        return orders;
    }

    // Sobrescrita dos métodos equals e hashCode

    // Compara se dois usuários são iguais com base no ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    // Gera um código de hash para o usuário com base no ID
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
