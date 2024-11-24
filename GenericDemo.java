package com.louis;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class GenericDemo {
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
}
