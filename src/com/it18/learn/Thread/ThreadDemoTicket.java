package com.it18.learn.Thread;

/**
 * Created by Think on 2017/12/11.
 */
public class ThreadDemoTicket {
    public static void main(String[] args) {
        salerT s1=new salerT("zhang");
        salerT s2=new salerT("wang");
        s1.start();
        s2.start();
    }
}

class salerT extends  Thread{
    static Object lock=new Object();//静态变量所有对象都能当锁，此例子以object作为锁
    static int tickets=100;//静态变量
    private String name;
    public  salerT(String name)
    {
        this.name=name;
    }

    public  void run() {
        while (tickets > 0)
        {
            int currticket=tickets;
            System.out.println(name+":"+currticket);
            synchronized (lock){//同步代码块,synchronized进入该代码块进来会加锁
                //如果加入ticket-1 则在第一张出问题，
                // //如果加如注释行的则在最后一张出问题
               // int currticket=tickets;
              //  System.out.println(name+":"+currticket);
                tickets=tickets-1;
            }


        }

    }

}
