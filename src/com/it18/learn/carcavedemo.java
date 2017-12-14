package com.it18.learn;

/**
 * Created by Think on 2017/12/13.
 */
public class carcavedemo {
    public static void main(String[] args) {
        cave cave=new cave();
        car car1 =new car(cave,2000,"汽车");
        car car2 =new car(cave,1000,"法拉利车");
        car car3 =new car(cave,3000,"牛车");
         car1.start();
         car2.start();
         car3.start();

    }
}

class cave { //汽车通过山洞
    public  synchronized  void crosscar(car car)
    {

        try {
            System.out.println(car.name+"开始过山洞 ");
            Thread.sleep(car.time);
            System.out.println(car.name+"出山洞 ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
class  car extends Thread{

    public cave cave;
    public  int time;
    public  String name;
    public car(cave cave,int time,String name)
    {
        this.cave=cave;
        this.time=time;
        this.name=name;

    }
   public  void run(){
        cave.crosscar(this);

   }

}