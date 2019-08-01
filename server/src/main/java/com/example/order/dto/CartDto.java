package com.example.order.dto;

import lombok.Data;

/**
 * @author hongwei
 * @date 2019/7/15 23:05
 */
@Data
public class CartDto {
    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
