package com.louis.gui.abserver;

import org.junit.Test;

public class TestDemo {
    @Test
    public void testObserver(){
        Message message = new Message();
        Observer user1 = new User("lily");
        Observer user2 = new User("tom");
        Observer user3 = new User("ben");
        message.registerObserver(user1);
        message.registerObserver(user2);
        message.registerObserver(user3);

        message.setMessage("hello！！");

        message.removeObserver(user1);
        message.setMessage("你好！！");
    }
}
