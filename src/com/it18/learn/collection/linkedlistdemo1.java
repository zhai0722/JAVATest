package com.it18.learn.collection;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Think on 2017/12/18.
 * linkedlist指针指出的pre ,next
 * 查询数据：linked查询需要一个一个遍历，因此查询arraylist快
 * 插入数据：linked比arraylist快，因为arraylist需要将所有插入后的数据往后移动; 而linked需要断开链接重写将新元素链接即可
 总结：arraylist 写慢 读快，linkedlist 写快 读慢
 */
public class linkedlistdemo1 {
    @Test
    public void test(){
        int max=10000;
        List<String> listS =new LinkedList<String>();
        List<Integer> list =new LinkedList<Integer>();
        List<Integer> list1=new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);

        list.add(0,5);
        listS.add("tom");
      listS.remove("tom");
    }
}
