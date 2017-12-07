package java.it18.learn;

/**
 * 接口都是abstract
 * 多继承
 * Created by Think on 2017/12/5.
 */
public class InterfaceDemo1 {
    public static void main(String[] args) {
        Mouse m=new Mouse();
        PC pc=new PC();
        keyboard kb=new keyboard();
        TV t=new TV();
        pc.insertUSB(m);
        pc.insertUSB(kb);
        pc.insertUSB(m,"鼠标2" );
        t.play();

    }
}
class PC {
    public void insertUSB(USB usb) //添加USB的类型
    {
        System.out.println("insert usb");
        usb.play();
    }

    public void insertUSB(USB usb, String name)
    {
        System.out.println("insert usb");
        usb.play(name);
    }

}

interface USB
{
    public abstract void play();
    void play(String name);

}
class Mouse implements USB
{
    @Override
    public void play() {
        System.out.println("鼠标滑动");
    }

    @Override
    public void play(String name) {
        System.out.println(name+"滑动 ");
    }
}
class keyboard implements USB
{
    @Override
    public void play() {
        System.out.println("键盘可用 ");
    }

    @Override
    public void play(String name) {
        System.out.println(name+"可用 ");
    }
}
interface NotUSB
{
    public  abstract void play();
}
class TV implements NotUSB{

    @Override
    public void play() {
        System.out.println("看电视 ");
    }
}