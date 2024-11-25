package com.louis;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.junit.Test;

import java.util.*;

public class GenericDemo {

    @Test
    public void test5(){
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"louis");
        map.put(2,"tom");

        Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
        for (Map.Entry entry : entrySet){
            System.out.println(entry.getKey()+"->"+entry.getValue());
//            1->louis
//            2->tom
        }
    }

    @Test
    public void test4(){
        String[] arrays = {"louis","jack","tom","lily"};
        String[] strs = func(arrays,0,1);
        System.out.println(Arrays.toString(strs));
    }

    @Test
    public void test3(){
        Node<Number> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        //getData(n1); //10
       // getData(n2);//报错
        //n1 = n2; //不支持

        //getData2(n2);
        getUpperNumberData(n1);//data: 10
        getUpperNumberData(n2);//data: 20
    }

    public static void getData(Node<Number> node){
        System.out.println(node.getData());
    }

    //使用通配符定义泛型类型,此时只能输出,不能修改
    public static void getData2(Node<?> node){
        //node.setData(20);
        System.out.println(node.getData());
    }

    public static void getUpperNumberData(Node<? extends Number> data){
        //只能是Number类及其子类
        System.out.println("data: "+data.getData());
    }

    @Test
    public void testNode(){
        Node<String> node = new Node<>("louis");
        Node<Integer> intNode = new Node<>(10);

        System.out.println(node.getData());
        System.out.println(intNode.getData());
    }

    @Test
    public void test1(){
//        List<String> list = new ArrayList<String>();
        List<String> list = new ArrayList();
        list.add("louis");
//        list.add(10);
//        list.add(new Object());
        for (int i = 0; i <list.size() ; i++) {
            //如果我们不能确定集合中的元素类型,那么我们需要在处理元素时
            //要判断元素的类型,才能做相应的操作
        }
    }

    public static <T> T[] func(T[] array,int i ,int t){
        T temp = array[i];
        array[i] = array[t];
        array[t] = temp;
        return array;
    }
}
