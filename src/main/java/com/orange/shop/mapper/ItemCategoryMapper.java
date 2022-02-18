package com.orange.shop.mapper;

import com.orange.shop.base.BaseMapper;
import com.orange.shop.entity.ItemCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ItemCategoryMapper extends BaseMapper<ItemCategory> {
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
