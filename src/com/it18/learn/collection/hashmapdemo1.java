package com.it18.learn.collection;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Think on 2017/12/18.
 * hashmap通过数组和链表实现的
 * hashmap的put方法是分桶即取模。
 * put判断方法
 * 1.判断hashcode是否相同
 * 2如果hascode相同，判断是否同一对象
 * 3.是同一对象判断equals方法
 *hash的过程,本质是散列
 * 1.hashcode h=e.hashcode; h^(h>>>16)
 * 2.定位桶 newhash&(n-1)
 * 3.判断桶元素 为==NULL, 不空(hash==p.hash&&())
 */
public class hashmapdemo1 {
@Test
    public void test1(){
        Map<String,String> map=new HashMap<String,String>();
        map.put("k001","tom");
        map.put("k001","abc");
        map.put("k002","tomas");
        map.put("k003","tomas");

        System.out.println(map.size());//由于map中key是唯一的 所以只有三个

    }
    @Test
    public void testget1(){//get
        Map<String,String> map=new HashMap<String,String>();
        map.put("k001","tom");
        map.put("k001","abc");
        map.put("k002","tomas");
        map.put("k003","tomas");

        System.out.println(map.size());//由于map中key是唯一的 所以只有三个
        String value=map.get("k001");//get方法
        System.out.println(value);


    }
    @Test
    public void testread1(){//遍历1
        Map<String,String> map=new HashMap<String,String>();
        map.put("k001","tom");
        map.put("k001","abc");
        map.put("k002","tomas");
        map.put("k003","tomas");

        System.out.println(map.size());//由于map中key是唯一的 所以只有三个
        Set<Map.Entry<String,String>> entryset=map.entrySet();//遍历方法
        Iterator<Map.Entry<String,String>> it=entryset.iterator();
        while (it.hasNext())
        {
            Map.Entry<String,String> entry=it.next();
           String key= entry.getKey();
          String value=  entry.getValue();
            System.out.println(key+""+value);
        }



    }
    @Test
    public void testread2(){//遍历2  keyset遍历
        Map<String,String> map=new HashMap<String,String>();
        map.put("k001","tom");
        map.put("k001","abc");
        map.put("k002","tomas");
        map.put("k003","tomas");

        System.out.println(map.size());//由于map中key是唯一的 所以只有三个
        Set<String> keyset=map.keySet();//遍历方法
        Iterator<String> it=keyset.iterator();
        while (it.hasNext())
        {

            String key= it.next();
            String value=  map.get(key);
            System.out.println(key+""+value);
        }



    }
}
