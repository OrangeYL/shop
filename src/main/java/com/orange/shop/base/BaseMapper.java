package com.orange.shop.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 基础mapper,封装一些简单的方法
 * @author
 *
 */
public interface BaseMapper <T>{
    /**
     * 插入一个实体
     * @param entity
     */
    int insert(T entity) ;

    /**
     * 通过id进行修改
     */
    void updateById(T entity);

    /**
     * 通过对象获取实体
     * @param entity
     */
    T getByEntity(T entity);

    /**
     * 根据主键获取一个实体
     * @param id
     * @return
     */
    T load(Serializable id);

    /**
     * 通过对象查询分页
     */
    public List<T> findByEntity(T entity);

    /**
     * 删除
     * @param id
     * @return
     */
    public int deleteById(int id);


}
