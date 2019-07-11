package com.example.order.dao;

import com.example.order.OrderApplicationTests;
import com.example.order.domain.OrderMaster;
import com.example.order.enums.OrderStatusEnum;
import com.example.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@Component
public class OrderMasterMapperTest extends OrderApplicationTests {
    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Test
    public void insert() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("18812345678");
        orderMaster.setBuyerAddress("上海市");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        int i = orderMasterMapper.insertSelective(orderMaster);
        Assert.assertTrue(i>-1);
    }
}