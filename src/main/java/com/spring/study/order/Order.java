package com.spring.study.order;

public class Order {

    private Long memberId;
    private String itenName;
    private int itemPrice;
    private int discountPrice;

    public Order(Long memberId, String itenName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itenName = itenName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getItenName() {
        return itenName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itenName='" + itenName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }

    public int calculatePrice() {
        return itemPrice - discountPrice;
    }
}
