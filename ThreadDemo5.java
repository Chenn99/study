package com.louis;

import java.util.concurrent.*;

/**
 * JDK1.5线程池
 */
public class ThreadDemo5 {
    public static void main(String[] args) {
        //创建线程池（4种）
        //1创建一个单线程的线程池
        //ExecutorService es = Executors.newSingleThreadExecutor();
        //创建一个固定大小的线程池，单线程
       // ExecutorService es = Executors.newFixedThreadPool(1);
        //两个线程一起跑
        //ExecutorService es = Executors.newFixedThreadPool(2);
        //创建一个可缓存的线程池
       // ExecutorService es = Executors.newCachedThreadPool();

        ScheduledExecutorService es = Executors.newScheduledThreadPool(3);
//        es.execute(new MyRunnable6());
//        es.execute(new MyRunnable6());
        es.schedule(new MyRunnable6(),3000, TimeUnit.MILLISECONDS);
        //结束该线程
        es.shutdown();
    }
}

class MyRunnable6 implements  Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
//            System.out.println("run--"+i);
            System.out.println(Thread.currentThread().getName()+"--"+i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}