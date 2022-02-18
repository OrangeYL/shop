package com.orange.shop.service;

import com.orange.shop.base.BaseService;
import com.orange.shop.entity.Item;

import java.util.List;

public interface ItemService extends BaseService<Item> {

    /**
     * 查询折扣商品
     * @return
     */
    public List<Item> queryDiscountItem();

    /**
     * 查询热销商品
     * @return
     */
    public List<Item> queryHotSellItem();

    /**
     * 按关键字或者二级分类查询
     * @param item
     * @return
     */
    public List<Item> querySubOrKey(Item item,String condition);
}
