package com.it18.learn.EXtendsInterface;

/**
 * Created by Think on 2017/12/5.
 */
public class OverrideDemo1 {
    public static void main(String[] args) {
        Rich2Man s2=new Rich2Man();
       s2.earnmoney();
        s2.consume(800);
    }

}
class RichMan{
    public static void consume(int money)
    {
        if(money<500)
        {
            System.out.println("consume"+money);
        }
        else
        {
            System.out.println("cant over 500");
        }
    }
    private void produce()
    {
        System.out.println("produce");

    }
    public final void earnmoney()
    {
        System.out.println("earnmoney");

    }

}
class Rich2Man extends RichMan
{
    public static void  consume(int money)
    {
        if(money<1000)
        {
            System.out.println("consume"+money);
        }
        else
        {
            System.out.println("cant over 500");
        }

    }

}