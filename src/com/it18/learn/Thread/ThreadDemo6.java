package com.it18.learn.Thread;

/**
 * Created by Think on 2017/12/14.
 */
public class ThreadDemo6 {
    public static void main(String[] args) {
        System.out.println("hello");
        Thread t=Thread.currentThread();
        System.out.println(t.getName());
        t.setName("a");
        System.out.println(t.getName());
        t.setPriority(10);
        int p=t.getPriority();

        System.out.println(p);
    }
}
