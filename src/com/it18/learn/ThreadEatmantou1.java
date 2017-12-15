package com.it18.learn;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Think on 2017/12/15.
 * Monk最多吃3个馒头
 */
public class ThreadEatmantou1 {
    public static void main(String[] args) {
        basket basket=new basket();

        for (int i=0;i<100;i++)
        {
            new monk(basket,"tom"+i).start();
        }

    }
}
//篮子
class basket {
    private int max = 150;
    private List<Integer> list = new LinkedList<Integer>();

    //初始化篮子
    public basket() {
        for (int i = 1; i < max; i++) {
            list.add(new Integer(i));
        }
    }

    //从篮子里取馒头
    public synchronized Integer getmantou(monk monk, int monknum) {
        //吃饱了或者没馒头了
        if (list.isEmpty() || monk.eatnum == monk.eatmax) {
            this.notifyAll();//通知
            return new Integer(-1);

        }
        //没吃馒头
        if (monk.eatnum == 0) {
            Integer i = list.remove(0);
            this.notify();
            return i;
        }


        //吃了一个馒头
        while (monk.eatnum == 1) {
            if (list.isEmpty()) {
                return -1;
            }
            if (max - list.size() < monknum)//如果剩余馒头小于和尚数量
            {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {

                Integer i = list.remove(0);
                this.notify();
                return i;

            }

        }


            Integer i = list.remove(0);
            this.notify();
            return i;



    }
}

class monk extends  Thread
{
    public int eatnum=0;//已经吃了
    public static int  eatmax=3;//最多吃3个
    public static int monknum=100;
    private  basket basket;
    public  String name;
    public  monk(basket basket,String name)
    {
        this.basket=basket;
        this.name=name;
    }
    public  void run() {
        while (true)
        {
            Integer i=basket.getmantou(this,monknum);
            if(i==-1)
            {
                return;
            }
            eatnum++;
            System.out.println(name+":"+i+":"+eatnum);
        }
    }

}