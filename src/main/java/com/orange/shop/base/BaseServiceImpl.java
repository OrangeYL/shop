package com.orange.shop.base;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    private BaseMapper<T> baseMapper;

    public abstract BaseMapper<T> getBaseDao();

    /**
     * 插入一个实体
     * @param entity
     */
    public int insert(T entity) {
        return this.getBaseDao().insert(entity);
    }

    /**
     * 通过id进行修改
     */
    public void updateById(T entity) {
        this.getBaseDao().updateById(entity);
    }

    /**
     * 通过对象获取实体
     *
     * @param entity
     */
    @Override
    public T getByEntity(T entity) {
        return this.getBaseDao().getByEntity(entity);
    }

    /**
     * 根据主键获取一个实体
     */
    public T load(Serializable id) {
        return this.getBaseDao().load(id);
    }

    /**
     * 通过对象查询分页
     * @param entity
     * @return
     */
    public List<T> findByEntity(T entity){
        return this.getBaseDao().findByEntity(entity);
    }

    /**
     * 封装分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param entity
     * @return
     */
    @Override
    public PageInfo<T> queryByPage(int pageNum, int pageSize, T entity) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<T> list = findByEntity(entity);
        PageInfo<T> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return this.getBaseDao().deleteById(id);
    }

    /**
     * 删除
     *
     * @param entity
     * @param pageNum
     * @param pageTotal
     * @return
     */
    @Override
    public int PageDelete(T entity, int pageNum, int pageTotal) {
        updateById(entity);
        if(pageNum!=1){
            if(pageTotal%5==0){
                pageNum=pageNum-1;
            }
        }
        return pageNum;
    }
}
