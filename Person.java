package com.louis;

public class Person implements Subject,Hotel{
    @Override
    public void shopping() {
        System.out.println("付款,买衣服!");
    }

    @Override
    public void reserve() {
        System.out.println("付款预定,已经定酒店!");
    }
}
