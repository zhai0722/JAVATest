package com.it18.learn;

/**
 * Created by Think on 2017/12/14.
 * 匿名内部类
 */
public class runnabledemo2 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("helloworld");
            }
        }).start();
    }
}
