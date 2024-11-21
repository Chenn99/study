package com.louis.bean;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanTest {
    @Test
    public void test(){
        //从客户端获取到的数据是这样的
        String name = "ben";
        String age = "18";
        String salary = "20000";

        Emp emp = new Emp();
        try {
            BeanUtils.setProperty(emp,"name",name);
            BeanUtils.setProperty(emp,"age",age);
            BeanUtils.setProperty(emp,"salary",salary);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        System.out.println(emp.getInfo());
//        name=ben,age=18,salary=20000
    }
}
