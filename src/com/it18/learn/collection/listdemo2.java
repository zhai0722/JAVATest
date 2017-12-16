package com.it18.learn.collection;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Think on 2017/12/15.
 */
public class listdemo2 {

    public static void main(String[] args) {
        List<cat> list=new ArrayList<cat>();
        long start=System.currentTimeMillis();

        for(int i=0;i<100000;i++)
        {
            list.add(new cat("tom",i%100));

        }
        System.out.println("put"+(System.currentTimeMillis()-start));
        start=System.currentTimeMillis();
        for(int i =0;i<list.size();i++)
        {

            cat cat=list.get(i);

        }
        System.out.println("get"+(System.currentTimeMillis()-start));

    }
}

class cat{
    private String name;
    private int age;
    public  cat(String name,int age)
    {
        this.name=name;
        this.age=age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}