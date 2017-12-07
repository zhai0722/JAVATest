package java.it18.learn;

/**
 * Created by Think on 2017/12/5.
 */
public class AbstractClassDemo1 {
    public static void main(String[] args) {
        absSportCar abscar=new absSportCar();
        String color1 = abscar.color;

        System.out.println(color1);
        abscar.run("yellow");
    }
}

abstract class absCar
        {
            public String color="red";
            public int tres;
            public void run(){};

        }
class absSportCar extends absCar
{

    public void run(String color) {
        this.color=color;
        System.out.println(this.color+" sportcar running");

    }
}
