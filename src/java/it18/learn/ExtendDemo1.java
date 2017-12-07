package java.it18.learn;

/**
 * Created by Think on 2017/12/5.
 */
public class ExtendDemo1 {
    public static void main(String[] args) {
BMWCar car1=new BMWCar();
        System.out.println(car1.speed);
    }
}
class Car {
    public String color;

    public void run()
    {
        System.out.println("running");
    }
}
class SportCar extends Car{

    public int speed;
    public  SportCar(int speed)
    {
        this.speed=speed;
        System.out.println("new sport car");

    }
}
class BMWCar extends SportCar
{
    public int price;



    public BMWCar() {
        super(220);
        System.out.println("new BMWSportCar");
    }
}
