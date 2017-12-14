package com.it18.learn;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by Think on 2017/12/14.
 * 死锁出现后解决方法
 * 方法1 wait加参数
 * 方法2 notifyall
 */
public class productconsumerlockdemo1
{
    public static void main(String[] args) {
        pool1 pool1=new pool1();
        productor3 p3=new productor3("p3",pool1);
        consumer2 c1=new consumer2("c1",pool1);
        consumer2 c2=new consumer2("c2",pool1);
        p3.start();
        c1.start();
        c2.start();
    }

}

class pool1{
    private  int max=1;
    private List<Integer> list= new LinkedList<Integer>();
    public  void addlast(int n)
    {
        synchronized (this)
        {
            while (list.size()>=max)
            {
                try {
                    Thread ct=Thread.currentThread();
                    System.out.println(ct.getName()+"wait()");
                    this.wait();//方法1 添加参数
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Integer(n));
            Thread ct1=Thread.currentThread();
            System.out.println(ct1.getName()+"notify()");
            this.notifyAll();
        }
    }
    public  int remove()
    {
        synchronized (this)
        {
            while (list.size()==0)
            {
                try {
                    Thread ct=Thread.currentThread();
                    System.out.println(ct.getName()+"wait()");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
           int no= list.remove(0);
            Thread ct1=Thread.currentThread();
            System.out.println(ct1.getName()+"notify()");
            this.notifyAll();
            return no;
        }
    }
}
//生产者
class productor3 extends  Thread
{
    private  String name;
    public  pool1 pool;
    static  int i =1;
    public  productor3(String name,pool1 pool)
    {
        this.name=name;
        this.pool=pool;
    }
    public  void run(){
        while (true)
        {
            pool.addlast(i++);
            System.out.println("p"+i);
        }
    }

}
//消费者
class consumer2 extends  Thread{
    private  pool1 pool;
    public  String name;
    public  consumer2(String name,pool1 pool)
    {
        this.name=name;
        this.pool=pool;
    }
  public  void run(){
        while (true)
        {
            int no=pool.remove();
            System.out.println("c"+no);
        }

  }
}