package com.orange.shop.service.impl;

import com.orange.shop.base.BaseMapper;
import com.orange.shop.base.BaseServiceImpl;
import com.orange.shop.entity.ItemOrder;
import com.orange.shop.mapper.ItemOrderMapper;
import com.orange.shop.service.ItemOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemOrderServiceImpl extends BaseServiceImpl<ItemOrder> implements ItemOrderService {

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Override
    public BaseMapper<ItemOrder> getBaseDao() {
        return itemOrderMapper;
    }
}
