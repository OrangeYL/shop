package com.orange.shop.service.impl;

import com.orange.shop.base.BaseMapper;
import com.orange.shop.base.BaseServiceImpl;
import com.orange.shop.entity.ItemCategory;
import com.orange.shop.mapper.ItemCategoryMapper;
import com.orange.shop.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCategoryServiceImpl extends BaseServiceImpl<ItemCategory> implements ItemCategoryService {

    @Autowired
    private ItemCategoryMapper itemCategoryMapper;

    @Override
    public BaseMapper<ItemCategory> getBaseDao() {
        return  itemCategoryMapper;
    }

    /**
     * 根据一级类目的id删除对应的二级类目
     *
     * @param id
     */
    @Override
    public int deleteByItemCategoryId(Integer id) {
        return itemCategoryMapper.deleteByItemCategoryId(id);
    }
    /**
     * 查询二级类目列表
     *
     * @return
     */
    @Override
    public List<ItemCategory> querySubItemCategory() {
        return itemCategoryMapper.querySubItemCategory();
    }

    /**
     * 根据一级类目id分页查询二级类目
     *
     * @param itemCategory
     * @return
     */
    @Override
    public List<ItemCategory> querySubItemCategoryPage(ItemCategory itemCategory) {
        return itemCategoryMapper.querySubItemCategoryPage(itemCategory);
    }

    /**
     * 查询一级类目列表，不分页
     *
     * @param itemCategory
     * @return
     */
    @Override
    public List<ItemCategory> queryItemCategory(ItemCategory itemCategory) {
        return itemCategoryMapper.queryItemCategory(itemCategory);
    }
}
