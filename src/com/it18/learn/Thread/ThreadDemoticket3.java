package com.it18.learn.Thread;

/**
 * Created by Think on 2017/12/11.
 */
public class ThreadDemoticket3 {
    public static void main(String[] args) {
        ticketpool pool=new ticketpool();
        salers s1=new salers("zhang",pool);
        salers s2=new salers("wang",pool);
        salers s3=new salers("dere",pool);
        salers s4=new salers("ccd",pool);
        s1.start();
        s2.start();
        s3.start();
        s4.start();
    }
}
class  ticketpool{//票池
    private int tickets=100;
    public  synchronized int gettick(){//同步方法块
        int ticket=tickets;
        tickets--;
        return  ticket;
    }

}

class salers extends  Thread{ //售票员
private  ticketpool pool =null;
private String name;
public salers(String name,ticketpool pool)
{
    this.name=name;
    this.pool=pool;

}
public  void run(){
    while (true)
    {
        int no=pool.gettick();
        if(no>0)
        {
            System.out.println(name+":"+no);
        }
        else {
            return;
        }
    }
}

}