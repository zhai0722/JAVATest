package com.it18.learn.collection;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Think on 2017/12/15.
 */
public class listdemo1 {
    @Test
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();


        for(int i=0;i<11;i++)
        {
            list.add("tom"+i);
        }
        System.out.println(list.size());
    }
}
