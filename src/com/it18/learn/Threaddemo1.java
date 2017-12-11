package com.it18.learn;

/**
 * Created by Think on 2017/12/11.
 */
public class Threaddemo1 {
    public static void main(String[] args) {
        mythread th=new mythread();
        mythread2 th2=new mythread2();
        th.start();//主线程执行
        th2.start();
    }
}

class mythread extends Thread
{
    public void run()//分线程执行
    {
        while (true) {
            System.out.println("mys thread");
            yield();//暂时放弃CPU的抢占权
        }
    }
}
class mythread2 extends Thread
{
    public void run()//分线程执行
    {
        while (true) {
            System.out.println("mys thread2");
            yield();//暂时放弃CPU的抢占权
        }
    }
}