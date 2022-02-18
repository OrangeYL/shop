package com.orange.shop.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 商品实体类
 */
public class Item implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private Float price;

    /**
     * 折扣
     */
    private Integer discount;

    /**
     * 收藏数
     */
    private Integer collectNum;

    /**
     * 购买数
     */
    private Integer buyNum;

    /**
     * 主图
     */
    private String url1;

    /**
     * 副图1
     */
    private String url2;

    /**
     * 副图2
     */
    private String url3;

    /**
     * 副图3
     */
    private String url4;

    /**
     * 副图4
     */
    private String url5;

    /**
     * 描述
     */
    private String des;

    private String pam1;
    private String pam2;
    private String pam3;
    private String val1;
    private String val2;
    private String val3;

    private Integer type;

    /**
     * 类别id一级
     */
    private Integer categoryIdOne;

    private ItemCategory parent;

    /**
     * 类别id二级
     */
    private Integer categoryIdTwo;

    private ItemCategory sub;

    /**
     * 是否有效 0有效 1已删除
     */
    private Integer isDelete;

    /**
     * 评论列表
     */
    private List<Comment> appraise;

    public List<Comment> getAppraise() {
        return appraise;
    }

    public void setAppraise(List<Comment> appraise) {
        this.appraise = appraise;
    }

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }

    public String getUrl4() {
        return url4;
    }

    public void setUrl4(String url4) {
        this.url4 = url4;
    }

    public String getUrl5() {
        return url5;
    }

    public void setUrl5(String url5) {
        this.url5 = url5;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getPam1() {
        return pam1;
    }

    public void setPam1(String pam1) {
        this.pam1 = pam1;
    }

    public String getPam2() {
        return pam2;
    }

    public void setPam2(String pam2) {
        this.pam2 = pam2;
    }

    public String getPam3() {
        return pam3;
    }

    public void setPam3(String pam3) {
        this.pam3 = pam3;
    }

    public String getVal1() {
        return val1;
    }

    public void setVal1(String val1) {
        this.val1 = val1;
    }

    public String getVal2() {
        return val2;
    }

    public void setVal2(String val2) {
        this.val2 = val2;
    }

    public String getVal3() {
        return val3;
    }

    public void setVal3(String val3) {
        this.val3 = val3;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCategoryIdOne() {
        return categoryIdOne;
    }

    public void setCategoryIdOne(Integer categoryIdOne) {
        this.categoryIdOne = categoryIdOne;
    }

    public ItemCategory getParent() {
        return parent;
    }

    public void setParent(ItemCategory parent) {
        this.parent = parent;
    }

    public Integer getCategoryIdTwo() {
        return categoryIdTwo;
    }

    public void setCategoryIdTwo(Integer categoryIdTwo) {
        this.categoryIdTwo = categoryIdTwo;
    }

    public ItemCategory getSub() {
        return sub;
    }

    public void setSub(ItemCategory sub) {
        this.sub = sub;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", collectNum=" + collectNum +
                ", buyNum=" + buyNum +
                ", url1='" + url1 + '\'' +
                ", url2='" + url2 + '\'' +
                ", url3='" + url3 + '\'' +
                ", url4='" + url4 + '\'' +
                ", url5='" + url5 + '\'' +
                ", des='" + des + '\'' +
                ", pam1='" + pam1 + '\'' +
                ", pam2='" + pam2 + '\'' +
                ", pam3='" + pam3 + '\'' +
                ", val1='" + val1 + '\'' +
                ", val2='" + val2 + '\'' +
                ", val3='" + val3 + '\'' +
                ", type=" + type +
                ", categoryIdOne=" + categoryIdOne +
                ", parent=" + parent +
                ", categoryIdTwo=" + categoryIdTwo +
                ", sub=" + sub +
                ", isDelete=" + isDelete +
                ", appraise=" + appraise +
                '}';
    }
}
