package com.orange.shop.mapper;

import com.orange.shop.base.BaseMapper;
import com.orange.shop.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemMapper extends BaseMapper<Item> {
    /**
     * 查询折扣商品
     * @return
     */
    public  List<Item> queryDiscountItem();

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
    public List<Item> querySubOrKey(@Param("item") Item item, @Param("condition") String condition);

}
