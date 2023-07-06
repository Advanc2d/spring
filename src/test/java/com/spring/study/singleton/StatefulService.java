package com.spring.study.singleton;

public class StatefulService {
    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name + "\t price = " + price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
