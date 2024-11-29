package com.lous;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//消除警告信息
@SuppressWarnings("all")
public class AnnotaionDemo {
    @Test
    public void test(){
        Cat cat = new Cat("喵喵","3");
        cat.printInfo();//调用一个已过时的方法

        List list = new ArrayList();
        list.add("louis");
        list.add(10);
        list.add(10.1f);
    }
}
