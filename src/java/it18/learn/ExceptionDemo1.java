package java.it18.learn;

/**
 * Created by Think on 2017/12/7.
 */
public class ExceptionDemo1 {
    public static void main(String[] args) {
        person p=new person();

        try {
            p.setAge(201);

            System.out.println(p.getAge());
        } catch (agetoooldexception e) {
            e.printlnerror();
        }
        catch (agetoosmallexception e) {
            e.printlnerror();
        }
        catch (ageinvildexception e) {
            e.printlnerror();
        }

    }
}
class person
{
    private  int age;
    public  int getAge(){
        return  age;
    }
    public void setAge(int age) throws agetoooldexception,agetoosmallexception,ageinvildexception
    { if(age>200)
    {throw  new agetoooldexception();}
     else if(age==0)
     {throw new agetoosmallexception();}
    else if(age<0)
    {throw new ageinvildexception("年龄非法");}
        this.age=age;
    }


}


class ageinvildexception extends Exception
{
    private  String info;
    public  ageinvildexception(String info)
    {
        this.info=info;
    }
    public  void printlnerror()
    {
        System.out.println(info);
    }
}


class agetoooldexception extends ageinvildexception
{
    public String info;

    public agetoooldexception(String info) {
        super(info);
    }

    //    public agetoooldexception(String info)
//    {
//        this.info=info;
//    }
    public agetoooldexception()
    {
        this("年龄太大");
    }
//    public  void printlnerror()
//    {
//        System.out.println(info);
//    }

}
class agetoosmallexception extends ageinvildexception {
    public agetoosmallexception(String info) {
        super(info);
    }

    public agetoosmallexception()
    {
        this("年龄太小");
    }
}
