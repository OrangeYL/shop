package com.orange.shop.service;

import com.orange.shop.base.BaseService;
import com.orange.shop.entity.ItemCategory;

import java.util.List;

public interface ItemCategoryService extends BaseService<ItemCategory> {

    /**
     * 根据一级类目的id删除对应的二级类目
     * @param id
     */
    public int deleteByItemCategoryId(Integer id);


    /**
     * 查询二级类目列表
     * @return
     */
    public List<ItemCategory> querySubItemCategory();

    /**
     * 根据一级类目id分页查询二级类目
     * @param itemCategory
     * @return
     */
    public List<ItemCategory> querySubItemCategoryPage(ItemCategory itemCategory);

    /**
     * 查询一级类目列表，不分页
     * @param itemCategory
     * @return
     */
    public List<ItemCategory> queryItemCategory(ItemCategory itemCategory);
}
