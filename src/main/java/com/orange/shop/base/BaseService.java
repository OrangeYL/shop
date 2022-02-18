package com.orange.shop.base;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public interface BaseService <T>{
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
     * 封装分页查询
     * @param pageNum
     * @param pageSize
     * @param entity
     * @return
     */
    public PageInfo<T> queryByPage(int pageNum,int pageSize,T entity);

    /**
     * 删除
     * @param id
     * @return
     */
    public int deleteById(int id);

    /**
     * 删除
     * @param entity
     * @param pageNum
     * @param pageTotal
     * @return
     */
    public int PageDelete(T entity,int pageNum,int pageTotal);
}
