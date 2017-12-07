package java.it18.learn;

/**
 * Created by Think on 2017/12/5.
 */
public class InterfaceDemo2 {
    public static void main(String[] args) {
 tuhao wang=new tuhao();
 womenstar fbb =new womenstar();
  wang.marry(fbb);
        System.out.println("---------------");
  White w= fbb;
  Rich r=fbb;
  Beau b=(Beau)w;
  b.verybeau();
    }
}
interface Rich{
    public  void hasmoney();

}
interface White{
    public  void verywhite();
}
interface Beau{
    public void verybeau();
}
interface RWB extends Rich,White,Beau{}//接口可多个继承

 class womenstar implements  RWB {
    @Override
    public void hasmoney() {
        System.out.println("有钱");
    }

    @Override
    public void verywhite() {
        System.out.println("很白 ");
    }

    @Override
    public void verybeau() {
        System.out.println("很美");
    }
}


class tuhao  {
public void marry(RWB w)
{
    w.hasmoney();
    w.verybeau();
    w.verywhite();

    System.out.println("不错 ");
}


}


