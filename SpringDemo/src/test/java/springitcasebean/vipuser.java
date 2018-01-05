package springitcasebean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Think on 2018/1/6.
 */
public class vipuser {
    @Autowired
    public  user user;

    @Override
    public String toString() {
        return "I AM VIP" + user.getName() ;
    }
}
