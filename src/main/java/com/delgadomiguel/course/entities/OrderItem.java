package com.delgadomiguel.course.entities;

import com.delgadomiguel.course.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK(); // Chave primária composta para identificar exclusivamente cada item de pedido

    private Integer quantity; // Quantidade do produto neste item do pedido
    private Double price; // Preço unitário do produto

    public OrderItem() {

    }

    // Construtor para inicializar os atributos da classe
    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        this.id.setOrder(order); // Define a ordem associada ao item
        this.id.setProduct(product); // Define o produto associado ao item
        this.quantity = quantity; // Define a quantidade do produto neste item
        this.price = price; // Define o preço do produto neste item
    }

    // Método para obter a ordem associada ao item
    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    // Método para definir a ordem associada ao item
    public void setOrder(Order order) {
        id.setOrder(order);
    }

    // Método para obter o produto associado ao item
    public Product getProduct() {
        return id.getProduct();
    }

    // Método para definir o produto associado ao item
    public void setProduct(Product product) {
        id.setProduct(product);
    }

    // Método para obter a quantidade do produto neste item do pedido
    public Integer getQuantity() {
        return quantity;
    }

    // Método para definir a quantidade do produto neste item do pedido
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // Método para obter o preço unitário do produto neste item do pedido
    public Double getPrice() {
        return price;
    }

    // Método para definir o preço unitário do produto neste item do pedido
    public void setPrice(Double price) {
        this.price = price;
    }

    // Sobrescrita do método equals para comparar dois itens de pedido
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id); // Compara os IDs dos itens de pedido
    }

    // Sobrescrita do método hashCode para gerar o código hash do objeto
    @Override
    public int hashCode() {
        return Objects.hash(id); // Gera o código hash com base no ID do item de pedido
    }
}
