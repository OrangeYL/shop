package com.orange.shop.entity;

import java.io.Serializable;

/**
 * 购物车
 */
public class Car implements Serializable {

    private Integer id;
    /**
     * 商品id
     */
    private Integer itemId;
    /**
     * 商品对象
     */
    private Item item;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 商品数量
     */
    private Integer num;

    /**
     * 商品单价
     */
    private Float price;

    /**
     * 商品总价
     */
    private Float total;

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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", item=" + item +
                ", userId=" + userId +
                ", num=" + num +
                ", price=" + price +
                ", total=" + total +
                '}';
    }
}
