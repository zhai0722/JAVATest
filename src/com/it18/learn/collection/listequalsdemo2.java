package com.it18.learn.collection;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Think on 2017/12/15.
 */
public class listequalsdemo2 {

    public static void main(String[] args) {
        int max=330;
        List<cat> list=new ArrayList<cat>();
        long start=System.currentTimeMillis();

        for(int i=0;i<max;i++)
        {
            list.add(new cat("tom"+i,i));

        }
        //indexof比较时，默认比较地址,由于引用的object的==，==比较地址
        //因此需要重写equals方法
        cat c=new cat("tom24",24);
        cat d=new cat("tom25",24);
        int eq=list.indexOf(c);

        System.out.println("对象相同么equals is "+eq);
        System.out.println("cat c:contains是否相同"+list.contains(c));
        System.out.println("cat :contains是否相同"+list.contains(d));


        System.out.println("put"+(System.currentTimeMillis()-start));
        start=System.currentTimeMillis();
        for(int i =0;i<list.size();i++)
        {

            cat cat=list.get(i);

        }
        System.out.println("get"+(System.currentTimeMillis()-start));
        System.out.println("==============================");
        //迭代器方式实现对List的遍历访问
        //只能往后滚动
        Iterator<cat> it =list.iterator();
        start=System.currentTimeMillis();
        while (it.hasNext())
        {
           cat cat1= it.next();
           int index=list.indexOf(cat1);

         //  System.out.println(index);
        }
        System.out.println("hasnext"+(System.currentTimeMillis()-start));

    }
}

class cat{
    private String name;
    private int age;
    public  cat(String name,int age)
    {
        this.name=name;
        this.age=age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
        {
            return  true;
        }

        //传入的为空
    if(obj==null){return  false;}
    //传入的类与类不同
        Class objclazz=obj.getClass();
        if(objclazz!=cat.class){return  false;     }
        //强制转换成cat
        cat b=(cat)obj;
        String bname=b.getName();//字符串
        int bage=b.getAge();
        //内容是否相同 字符串equals是比较内容
//        if(bname.equals(this.name)&&bage==this.age)
//        {return true;}
        boolean nameEqual=false;
        if(name==null)
        {
            if(bname==null)
            {
                nameEqual=true;
            }


        }
        else{
            nameEqual=name.equals(bname);
        }
        return nameEqual&&(age==bage);
    }

}