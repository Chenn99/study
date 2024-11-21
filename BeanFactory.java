package com.louis.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 通过内省的API来装配一个Bean对象，Bean对象的值是通过配置文件中来获取
 * 目的是为了提高维护性
 */
public class BeanFactory {
    private static Properties prop = new Properties();
    //使用静态代码块读取配置文件
    static {
        //线程
        InputStream in = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream("com/louis/introspector/config.propperties");
        try {
            prop.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取一个Bean
     * @param name
     * @return
     */
    public static Object getBean(String name){
        Object bean = null;
        String beanName = prop.getProperty(name);
        try {
            Class<?> aClass = Class.forName(beanName);
            bean = aClass.newInstance();
            //通过类信息获取javaBean的描述信息
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
            //通过javaBean描述信息，获取该类的所有属性描述器
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                String propertyName = propertyDescriptors[i].getName();
                Method writeMethod = propertyDescriptors[i].getWriteMethod();
                if ("username".equals(propertyName)){
                    //相当于调用属性的set方法
                    writeMethod.invoke(bean,prop.getProperty("bean.username"));
                }else if ("password".equals(propertyName)){
                    writeMethod.invoke(bean,prop.getProperty("bean.password"));
                } else if ("url".equals(propertyName)) {
                    writeMethod.invoke(bean,prop.getProperty("bean.url"));
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
        return bean;
    }
}
