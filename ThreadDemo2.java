package com.louis;
/**
 * join 方法：
 * 加入线程，让调用的线程先执行指定时间或执行完毕
 * 中断线程：
 * （1）使用interrupt方法来中断，设置一个中断状态（标记）
 * （2）自定义标记的方式（推荐使用）
 */
public class ThreadDemo2 {
    public static void main(String[] args) throws InterruptedException {

        MyRunnable2 mr2 = new MyRunnable2();
        Thread t = new Thread(mr2);
//        t.start();

        MyRunnable3 mr3 = new MyRunnable3();
        Thread t2 = new Thread(mr3);
        t2.start();

        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);

            try{
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 20) {
//                try{
//                    t.join(); //让t线程执行完毕
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//               t.interrupt();//中断线程，只是做了个中断标记
                mr3.flag = false;
            }
        }
    }
}

class  MyRunnable2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (Thread.interrupted()){ //测试中断标记，此方法会把中断状态清除
                break;
            }
            System.out.println(Thread.currentThread().getName()+"--"+i);

            try{
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}

class  MyRunnable3 implements  Runnable{
    public  boolean flag= true;
    public MyRunnable3(){
        flag = true;
    }
    @Override
    public void run(){
        int i = 0;
        while(flag){
            System.out.println(Thread.currentThread().getName()+"==="+i++);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}