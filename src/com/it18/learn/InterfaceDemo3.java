package com.it18.learn;

/**
 * Created by Think on 2017/12/6.
 * 常量
 */
public class InterfaceDemo3 {
    public static void main(String[] args) {
        jing8 j=new jing8();
        j.meng();
    }


}
interface Pet{
    int legs = 4;
     void meng();
}
class jing8 implements Pet{

    @Override
    public void meng() {
        System.out.println(legs);

    }
}