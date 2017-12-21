package com.it18.learn.collection;

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Think on 2017/12/18.
 */
public class treesetdemo1 {
    public void treeadd(){
        Set<Integer> set=new TreeSet<Integer>();
        set.add(0);
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set.size());
    }
    @Test
    public void treeadddog(){
        Set<dog> set=new TreeSet<dog>(new dogcompare());//增加对比器方式
        set.add(new dog("大荒1"));//compare无法转化狗对象，来tree计算，需要重写compare
        set.add(new dog("大荒2"));
        set.add(new dog("大荒3"));
        set.add(new dog("大荒4"));
        System.out.println("dog"+set.size());
        Set<dog> set2=new TreeSet<dog>();//增加对比器方式
        set2.add(new dog("大荒1"));//compare无法转化狗对象，来tree计算，需要重写compare
        set2.add(new dog("大荒2"));
        set2.add(new dog("大荒3"));
        System.out.println("dog"+set2.size());
        System.out.println("大荒".compareTo("二黄"));
        Iterator<dog> it =set.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next().name);
        }

    }
    //dog对比器
    class dogcompare implements Comparator<dog>
    {
        public  int compare (dog d1,dog d2)
        {
            if (d1==null)
            {
                if(d2==null)
                {
                    return  0;
                }
                else {return  -1;}
            }
            else {
                if(d2==null)
                {
                    return 1;
                }
                else{
                   return d1.name.compareTo(d2.name);
                }
            }



        }

    }
    public   class  dog implements Comparable<dog>
    {
        private  String name="";
        private dog(String name)
        {
            super();
            this.name=name;
        }


        @Override
        public int compareTo(dog o) {
            if(o==null)
            {
                return 1;
            }
            return   this.name.compareTo(o.name);

        }
    }
}
