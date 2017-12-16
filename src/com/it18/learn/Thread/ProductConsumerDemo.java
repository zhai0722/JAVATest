package com.it18.learn.Thread;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Think on 2017/12/13.
 */
public class ProductConsumerDemo {
    public static void main(String[] args) {
//        List<Integer> listdemo1= new LinkedList<Integer>();
//        listdemo1.add(new Integer(1));
//        listdemo1.add(new Integer(2));
//        listdemo1.add(new Integer(3));
//        listdemo1.add(new Integer(4));
//        System.out.println(listdemo1.size());
//        System.out.println(listdemo1.remove(0));
//        System.out.println(listdemo1.remove(0));
//        System.out.println(listdemo1.remove(0));
//        System.out.println(listdemo1.remove(0));
//        System.out.println(listdemo1.size());
        //创建集合
        List<Integer> list= new LinkedList<Integer>();
        product1 p=new product1(list);
        consumer1 c =new consumer1();
        p.start();
        c.start();


    }
}
//生产者
class product1 extends Thread{
    private List<Integer> list;
    public product1(List<Integer> list)
    {
        this.list=list;
    }
    public  void run()
    {
        int i=1;
    while (true)
    {

        list.add(new Integer(i));
        System.out.println("product:"+i);
        i++;


    }
    }

}
//消费者
class consumer1 extends Thread{
    private List<Integer> list;

    public  void run()
    {
        while (true)
        {
           if(!list.isEmpty()) {
              int no= list.remove(0);
               System.out.println("consumer:"+no);

           }

        }
    }

}



