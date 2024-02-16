package com.delgadomiguel.course.entities.enums;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    //Retorna o enum OrderStatus correspondente ao código fornecido.
    //Percorre todos os valores possíveis do tipo enum e verifica se o código fornecido corresponde a algum deles.
    //Se um valor correspondente for encontrado, retorna o OrderStatus equivalente; caso contrário, retorna null.
    public static OrderStatus valueOf(int code) {

        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code.");

    }

}
