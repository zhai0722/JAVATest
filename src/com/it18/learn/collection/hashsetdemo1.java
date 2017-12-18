package com.it18.learn.collection;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Think on 2017/12/18.
 * HASHSET线程不安全存取速度快
 */
@Test
public class hashsetdemo1 {
    public void test1(){
        Set<Integer> set=new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        System.out.println("size:"+set.size());//set对字符串无顺不重复
        Iterator<Integer> it=set.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
        Set<String> set2=new HashSet<String>();
        set2.add("tom");
        set2.add("tom");
        set2.add("TMOS");
        set2.add("TASFD");
        set2.add("ASDF");
        set2.add("SERD");
        System.out.println("size:"+set2.size());//set对字符串无顺不重复
        Iterator<String> it2=set2.iterator();
        while (it2.hasNext())
        {
            System.out.println(it2.next());
        }

    }
}



