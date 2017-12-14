package com.it18.learn;

/**
 * Created by Think on 2017/12/13.
 */
public class ThreadDemoTicketmachine {
    public static void main(String[] args) {
        ticketmachine m=new ticketmachine();
        for(int i=0;i<50;i++)
        {
            new persont(m,"Tom"+i).start();
        }

    }

}

class ticketmachine
{
    private  int ticketno=1;
    public synchronized int printticketno()
    {
        int currticketno=ticketno;
        ticketno++;
        return  currticketno;

    }

}
class persont extends  Thread{
    private  ticketmachine m;
    private String name;
    public  persont(ticketmachine m,String name)
    {
        this.m=m;
        this.name=name;
    }
    public  void run(){
     int no=m.printticketno();
        System.out.println(name+":"+no);
    }

}
