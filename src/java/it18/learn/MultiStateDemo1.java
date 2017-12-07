package java.it18.learn;
/**
 * Created by Think on 2017/12/6.
 */
public class MultiStateDemo1 {
    public static void main(String[] args) {
        multjing8 j=new multjing8();
        j.cry();
        j.meng();
        //多态
        MultDog dog= j;
        dog.cry();
        dog.watch();
        //多态
        Animal a=dog;
        a.cry();
        System.out.println("---------------------");
       // multjing8 j2= (multjing8) new MultDog();强制转换报错
      //  j2.meng();
        //多态
        multpet p= (multpet) a;
        p.meng();

    }
}
abstract  class Animal
{
    public  void cry()
    {
        System.out.println("wangwang");
    }
}
class  MultDog extends  Animal
{
    public  void watch(){
        System.out.println("kanjia");
    }

}
class multjing8 extends  MultDog implements multpet
    //multjing8继承了MultDog 可用用multdog看 继承了multpet 可用multpet看
{
    public void meng(){
        System.out.println("meng");
    }
}
interface  multpet{
    void meng();
}