package com.lous;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//消除警告信息
@SuppressWarnings("all")
public class AnnotaionDemo {

    //反射来处理注解
    @Test
    public void test2(){
        Class<Cat> catClass = Cat.class;
        //获取类上应用的指定注解
        MyAnnotation annotation = catClass.getAnnotation(MyAnnotation.class);
        //获取注解上变量值
        String name = annotation.name();
        String age = annotation.age();
        Color1 color1 = annotation.color1();
        String[] like = annotation.like();
        try {
            Cat cat = catClass.newInstance();
            cat.setName(name);
            cat.setAge(age);
            cat.setColor1(color1);
            cat.setLike(like);
            System.out.println(cat);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

//    @Test
//    public void test(){
//        Cat cat = new Cat("喵喵","3");
//        cat.printInfo();//调用一个已过时的方法
//
//        List list = new ArrayList();
//        list.add("louis");
//        list.add(10);
//        list.add(10.1f);
//    }
}
