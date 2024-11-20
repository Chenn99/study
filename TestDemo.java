package com.louis;

import org.junit.Test;

public class TestDemo {
    @Test
    public void testProxy(){
        CreateProxy createProxy = new CreateProxy();//用来创建代理对象的代理
//        Subject person = new Person();
        Hotel person = new Person();
        Hotel proxy = (Hotel)createProxy.create(person);
       // proxy.shopping();//invoke
        proxy.reserve();
//        上海外寻找客户需要的产品...
//        跟客户确认物品
//        付款,买衣服!
//          完成本次海淘
    }
}
