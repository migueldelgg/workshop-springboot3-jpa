package com.delgadomiguel.course.entities.pk;

import com.delgadomiguel.course.entities.Order;
import com.delgadomiguel.course.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order; // Representa a ordem associada ao item de pedido

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product; // Representa o produto associado ao item de pedido

    // Método para obter a ordem associada ao item de pedido
    public Order getOrder() {
        return order;
    }

    // Método para definir a ordem associada ao item de pedido
    public void setOrder(Order order) {
        this.order = order;
    }

    // Método para obter o produto associado ao item de pedido
    public Product getProduct() {
        return product;
    }

    // Método para definir o produto associado ao item de pedido
    public void setProduct(Product product) {
        this.product = product;
    }

    // Sobrescrita do método equals para comparar dois objetos OrderItemPK
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    // Sobrescrita do método hashCode para gerar o código hash do objeto
    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
