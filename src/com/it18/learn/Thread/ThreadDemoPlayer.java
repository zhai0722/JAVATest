package com.it18.learn.Thread;

/**
 * Created by Think on 2017/12/11.
 */
public class ThreadDemoPlayer {
    public static void main(String[] args) throws InterruptedException {
        player p1= new player("1",5000);
        player p2= new player("2",1000);
        player p3= new player("3",8000);
        player p4= new player("4",3000);
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        //start 放一起 join放一起才能多线程
        p1.join();//等到P1线程执行完后继续执行
        p2.join();//等到P2线程执行完后继续执行
        p3.join();//等到P3线程执行完后继续执行
        p4.join();//等到P4线程执行完后继续执行
        System.out.println("人齐了开局" );
    }
}

class player extends  Thread
{
    private  String name;
    private  int time;
    public  player (String name,int time)
    {
        this.name=name;
        this.time=time;
    }

    public  void run()
    {
        System.out.println("玩家"+name+"出发");
        try {
            //静态方法让当前线程休眠time毫秒
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("玩家"+name+"到了");

    }
}
