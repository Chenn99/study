package com.louis.bean;

import java.io.Serializable;

public class OrderItem implements Serializable {

    private int itemId;
    private Clothes clothes;//商品
    private int shoppingNum;
    private float sum;//购买金额

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemId=" + itemId +
                ", clothes=" + clothes +
                ", shoppingNum=" + shoppingNum +
                ", sum=" + sum +
                '}';
    }

    public OrderItem() {
    }

    public OrderItem(int itemId, Clothes clothes, int shoppingNum, float sum) {
        this.itemId = itemId;
        this.clothes = clothes;
        this.shoppingNum = shoppingNum;
        this.sum = sum;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public int getShoppingNum() {
        return shoppingNum;
    }

    public void setShoppingNum(int shoppingNum) {
        this.shoppingNum = shoppingNum;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }
}
