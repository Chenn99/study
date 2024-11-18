package com.louis;

import java.lang.reflect.*;

import org.junit.Test;

public class ReflectionDemo {

    @Test
    public void test5(){
        Dog dog = new Dog("wangwnag",4,"白色");
        Class<Dog> dogClass = Dog.class;
        //获取类的包名
        Package aPackage = dogClass.getPackage();
       // System.out.println(aPackage.getName()); //com.louis
        //获取公共的方法,包括继承的公有方法
        Method[] methods = dogClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
            if (methods[i].getName().equals("toString")){
                try {
                    String s = (String) methods[i].invoke(dog);
                    System.out.println(s);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //获取所有的属性
    @Test
    public void test4(){
        Class<Dog> dogClass = Dog.class;
        //获取非私有属性
        Field[] fields = dogClass.getFields();
//        System.out.println(fields.length);
        //获取所有属性(包括私有属性)
        Field[] declaredFields =  dogClass.getDeclaredFields();
//        System.out.println(declaredFields.length);
        for (int i = 0; i < declaredFields.length; i++) {
            int modifiers = declaredFields[i].getModifiers();
            System.out.println(Modifier.toString(modifiers)+" "+declaredFields[i].getType()+" "+declaredFields[i].getName());
        }
    }

    //获取所有构造方法
    @Test
    public void test3(){
        Class<Dog> dogClass = Dog.class;
        Constructor<?>[] constructors = dogClass.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i].getName());
            System.out.println(constructors[i].getParameterCount());

        }
        try {
            //获取一个指定的构造方法
            Constructor<Dog> constructor = dogClass.getConstructor(String.class,int.class,String.class);
            //调用带参数的构造器来实例化对象
            Dog dog = constructor.newInstance("xiaobai",5,"黑色");
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过反射来实例化对象
     */
    public void test2(){
       Class<Dog> dogClass = Dog.class;
        try {
            //通过CLass对象实例化类对象,调用了默认无参的构造方法
            Dog dog = (Dog)dogClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 获取Class对象的三种形式
     */
    @Test
    public void test1(){
        //通过对象的getClass()方法
        Dog dog = new Dog("wangwang",4,"白色");
        Class aClass = dog.getClass();

        //通过类.class
        Class dogClass = Dog.class;

        //通过Class.forName方法
        try {
            Class aClass1 = Class.forName("com.louis.Dog");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
