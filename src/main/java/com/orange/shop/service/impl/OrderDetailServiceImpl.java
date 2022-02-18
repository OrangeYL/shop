package com.orange.shop.service.impl;

import com.orange.shop.base.BaseMapper;
import com.orange.shop.base.BaseServiceImpl;
import com.orange.shop.entity.OrderDetail;
import com.orange.shop.mapper.OrderDetailMapper;
import com.orange.shop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail> implements OrderDetailService {
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public BaseMapper<OrderDetail> getBaseDao() {
        return orderDetailMapper;
    }
}
