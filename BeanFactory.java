package com.louis.aop;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class BeanFactory {
    Properties prop = new Properties();
    public BeanFactory(InputStream in){
        try {
            prop.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取一个Bean实例
     */
    public Object getBean(String name){
        String className = prop.getProperty(name);
        Object bean = null;
        try {
            //获取ProxyFactoryBean的Class对象
            Class<?> aClass = Class.forName(className);
            bean = aClass.newInstance();//实例化对象
            //根据配置文件实例化target和advice对象
            Object target = Class.forName(prop.getProperty(name+".target")).newInstance();
            Object advice = Class.forName(prop.getProperty(name+".advice")).newInstance();
            //通过内省实现对ProxyFactoryBean的属性赋值
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : propertyDescriptors){
                String propertyName = pd.getName();
                Method writeMethod = pd.getWriteMethod();
                if ("target".equals(propertyName)){
                    writeMethod.invoke(bean,target);
                } else if ("advice".equals(propertyName)) {
                    writeMethod.invoke(bean,advice);
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return bean;
    }
}
