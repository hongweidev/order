package com.example.order.service.impl;

import com.example.order.dao.OrderDetailMapper;
import com.example.order.dao.OrderMasterMapper;
import com.example.order.domain.OrderMaster;
import com.example.order.dto.OrderDto;
import com.example.order.enums.OrderStatusEnum;
import com.example.order.enums.PayStatusEnum;
import com.example.order.service.OrderService;
import com.example.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public OrderDto create(OrderDto orderDto) {
        // TODO 查询商品信息（调用商品服务）
        // TODO 计算总价
        // TODO 扣库存（调用商品服务）
        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDto.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDto, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterMapper.insertSelective(orderMaster);
        return orderDto;
    }
}
