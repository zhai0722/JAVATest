package com.it18.learn.Thread;

import java.util.Date;

/**
 * Created by Think on 2017/12/11.
 */
public class ThreadDemoKTV {
    public static void main(String[] args) {
        room r1=new room("no1",5000);
        waiter w=new waiter();
        //w.setDaemon(true);//设置线程为守护线程当r1结束后 w就不在继续报时,可以写在构造函数
        r1.start();
        w.start();

    }
}


class room extends  Thread
{
    private  String roomnum;
    private int time;
    public room(String roomnum ,int time)
    {
        this.roomnum=roomnum;
        this.time=time;
    }
    public  void run(){
        System.out.println(roomnum+"号房间正在唱歌 ");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("买单走人");
    }
}
class waiter extends  Thread
{
    public  waiter(){
        this.setDaemon(true);
    }//设置线程为守护线程当r1结束后 w就不在继续报时
    public void run()
    {
        while (true)
        {
            System.out.println("现在时间"+new Date());
            try {
                Thread.sleep(1000);//com.it18.learn.Thread.waiter 每隔1S报时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}