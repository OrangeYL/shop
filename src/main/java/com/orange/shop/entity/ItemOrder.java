package com.orange.shop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 */
public class ItemOrder implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 商品id
     */
    private Integer itemId;

    /**
     * 购买者id
     */
    private Integer userId;

    private User user;

    /**
     * 订单号
     */
    private String code;

    /**
     * 购买时间
     */
    private Date addTime;

    /**
     * 总价钱
     */
    private Float total;

    /**
     * 逻辑删（0未删除，1已删除）
     */
    private Byte isDelete;

    /**
     * 0.新建待发货1.已取消 2已发货3.到收货4已评价
     */
    private Byte status;

    private List<OrderDetail> details;

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ItemOrder{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", userId=" + userId +
                ", user=" + user +
                ", code='" + code + '\'' +
                ", addTime=" + addTime +
                ", total=" + total +
                ", isDelete=" + isDelete +
                ", status=" + status +
                ", details=" + details +
                '}';
    }
}
