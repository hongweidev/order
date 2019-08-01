package com.example.order.client;

import com.example.order.domain.ProductInfo;
import com.example.order.dto.CartDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author hongwei
 * @date 2019/7/11 22:25
 */
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();

    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(List<String> prodictIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(List<CartDto> cartDtoList);
}
