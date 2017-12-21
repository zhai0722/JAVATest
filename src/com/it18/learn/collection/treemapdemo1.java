package com.it18.learn.collection;

import java.util.*;
import com.it18.learn.collection.treesetdemo1;
import org.testng.annotations.Test;

/**
 * Created by Think on 2017/12/19.
 */
public class treemapdemo1 {
    @Test
    public void testput(){
        Map<dog,String> map=new TreeMap<dog, String>();
        map.put(new dog("大荒"),"is good");
        map.put(new dog("大荒2"),"is better");
        map.put(new dog("大荒3"),"is best");
        System.out.println(map.size());

    }


    class dogcompare implements Comparator<dog>
    {
        public  int compare (dog d1, dog d2)
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
