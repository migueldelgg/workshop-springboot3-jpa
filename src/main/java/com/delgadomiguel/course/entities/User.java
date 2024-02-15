package com.delgadomiguel.course.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_user") //User é uma palavra reservada do banco de dados H2
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // Significa que esse atributo é a chave primária do banco de dados
    @GeneratedValue (strategy = GenerationType.IDENTITY) //.Isso gera pode mudar a dependeer do banco de dados.
    private Long id; //  O valor gerado não é aleatório, mas sim sequencial.
    private String name;
    private String email;
    private String phone;
    private String password;

    @OneToMany(mappedBy = "client") // Um cliente pode ter muitos pedidos / Mapeado pelo atributo "client" da classe Order
    private List<Order> orders = new ArrayList<>(); // em caso de coleções, não criamos o método Set, apenas o Get

    public User(){
    }

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders(){
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
