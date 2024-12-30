package com.louis.gui.abserver;

/**
 * 被观察者的接口
 */
public interface Messagesubject {
    //注册观察者
    public void registerObserver(Observer o);
    //移除观察者
    public void removeObserver(Observer o);
    //通知所有观察者
    public void notifyObservers();
}
