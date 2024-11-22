package com.louis.aop;

import org.junit.Test;

import java.io.InputStream;

public class AOPTeat {
    @Test
    public void test(){
        //1读取配置文件
        InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/louis/aop/bean.properties");
        //2创建Bean的工厂对象
        BeanFactory beanFactory = new BeanFactory(in);
        //3获取代理对象
        ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean)beanFactory.getBean("bean");
        IManager proxy = (IManager)proxyFactoryBean.getProxy();
        proxy.add("我是一只猫");

    }
}
