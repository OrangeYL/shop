package com.orange.shop.service.impl;

import com.orange.shop.base.BaseMapper;
import com.orange.shop.base.BaseServiceImpl;
import com.orange.shop.entity.Item;
import com.orange.shop.mapper.ItemMapper;
import com.orange.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public BaseMapper<Item> getBaseDao() {
        return  itemMapper;
    }

    /**
     * 查询折扣商品
     *
     * @return
     */
    @Override
    public List<Item> queryDiscountItem() {
        return itemMapper.queryDiscountItem();
    }

    /**
     * 查询热销商品
     *
     * @return
     */
    @Override
    public List<Item> queryHotSellItem() {
       return itemMapper.queryHotSellItem();
    }

    /**
     * 按关键字或者二级分类查询
     *
     * @param item
     * @return
     */
    @Override
    public List<Item> querySubOrKey(Item item,String condition) {
        return itemMapper.querySubOrKey(item,condition);
    }
}
