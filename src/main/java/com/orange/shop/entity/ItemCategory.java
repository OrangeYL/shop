package com.orange.shop.entity;

import java.io.Serializable;

/**
 * 类目实体类
 */
public class ItemCategory implements Serializable {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 类目名称
     */
    private String name;
    /**
     * 父级id
     */
    private Integer pid;
    /**
     * 逻辑删除（0未删除，1已删除）
     */
    private Byte isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "ItemCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", isDelete=" + isDelete +
                '}';
    }
}
