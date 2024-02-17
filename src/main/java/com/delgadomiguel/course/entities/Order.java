package com.delgadomiguel.course.entities;

import com.delgadomiguel.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    // Identifica este atributo como a chave primária do banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // A estratégia de geração de valor para a chave primária (pode variar dependendo do banco de dados)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    // O momento em que o pedido foi realizado
    private Instant moment;

    // O código do status do pedido
    private Integer orderStatus;

    @ManyToOne
    // Relação muitos-para-um com a entidade User: muitos pedidos para um cliente
    @JoinColumn(name = "client_id") // Nome da chave estrangeira no banco de dados
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    public Order() {
    }

    // Construtor com todos os atributos
    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    // Getters e Setters

    // Retorna o ID do pedido
    public Long getId() {
        return id;
    }

    // Define o ID do pedido
    public void setId(Long id) {
        this.id = id;
    }

    // Retorna o momento em que o pedido foi realizado
    public Instant getMoment() {
        return moment;
    }

    // Define o momento em que o pedido foi realizado
    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    // Retorna o cliente associado ao pedido
    public User getClient() {
        return client;
    }

    // Define o cliente associado ao pedido
    public void setClient(User client) {
        this.client = client;
    }

    // Retorna o status do pedido como um enum OrderStatus
    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    // Define o status do pedido a partir de um enum OrderStatus
    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public Set<OrderItem> getItems(){
        return items;
    }

    // Sobrescrita dos métodos equals e hashCode
    // Compara se dois pedidos são iguais com base no ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    // Gera um código de hash para o pedido com base no ID
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
