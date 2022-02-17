package com.dio.base;

import java.math.BigDecimal;

/**
 * @author Willian Smaniotto
 * @version 1.0.0
 * @see BigDecimal
 * @since 1.0.0
 */

public class Order {

    private final String code;
    private final BigDecimal totalValue;

    /**
     * Construtor da clsse
     * 
     * @param code       : Código do pedidod
     * @param totalValue : Valor total do pedido
     */
    public Order(String code, BigDecimal totalValue){
        this.code = code;
        this.totalValue = totalValue;
    }

    @Override
    public String toString(){
        return "Order={" + "code='" + code + "'}";
    }

    /**
     * Calcula o valor total de acordo com as taxas do pedido
     * 
     * @return Valor total do pedido com as taxas calculadas
     * @throws RuntimeException Se o valor do pedido for negativo
     */
    public BigDecimal calculateFee() throws RuntimeException{

        if(this.totalValue.signum() < 0){
            throw new RuntimeException("O número naão pode ser negativo");
        }

        if (this.totalValue.compareTo(new BigDecimal("100.00")) > 100){
            return this.totalValue.multiply(new BigDecimal("0.99"));
        }

        return totalValue;
    }
}
