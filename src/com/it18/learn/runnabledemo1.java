package com.it18.learn;

/**
 * Created by Think on 2017/12/14.
 */
public class runnabledemo1
{

    public static void main(String[] args) {
        myrunnable r=new myrunnable("张");
        myrunnable r1=new myrunnable("李");
        r.run();
        r1.run();
    }
}

class myrunnable implements Runnable{
 private String name;
 public  myrunnable(String name)
 {
     this.name=name;
 }

    public  void run(){
        this.name=name;
        System.out.println(name+"hello");
    }
}