package com.it18.learn.Thread;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Think on 2017/12/13.
 */
public class productconsumerdemo2 {
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
        mylist2 list= new mylist2();
        product2 p=new product2(list);
        consumer2 c =new consumer2(list);
        p.start();
        c.start();


    }
}
class mylist2{
    private  int max=4;
    private  List<Integer> list=new LinkedList<Integer>();
    public  void add (Integer i)
    {
        while (true)
        {
            synchronized(list)
            {
                if(list.size()<max)
                {
                    list.add(i);
                    System.out.println("P:size"+list.size());
                    return;
                }
            }
        }



    }
    public    Integer remove()
    {
        while (true)
    {
        synchronized (list)
        {
            if(!list.isEmpty())
            {
                System.out.println("C:size"+list.size());
                return list.remove(0);

            }

        }

    }
    }

}
//生产者
class product2 extends Thread{
    private mylist2 list;
    public product2(mylist2 list)
    {
        this.list=list;
    }
    public  void run()
    {
         int i=1;
        while (true){
            list.add(i);
            System.out.println("product:"+i);
            i++;
        }
    }

}
//消费者
class consumer2 extends Thread{
    private mylist2 list;
    public  consumer2(mylist2 list)
    {
        this.list=list;
    }
    public  void run()
    {
while (true)
{
    int no=list.remove();
    System.out.println("consumer2"+no);
}

    }

}



