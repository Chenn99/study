package com.louis;

public class ThreadDemo1 {
    public static void main(String[] args) {

        MyThread mt = new MyThread();

        //推荐
        MyRunnable mr = new MyRunnable();
        Thread t2 = new Thread(mr);

        mt.start(); //启动线程
        t2.start();//启动线程
    }
}

/**
 * 实现线程的第一种方式,继承Thread类
 */
class MyThread extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+"-"+i);

            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 实现线程的第二种方式,实现Runnable接口
 */
class MyRunnable implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+"-"+i);
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}