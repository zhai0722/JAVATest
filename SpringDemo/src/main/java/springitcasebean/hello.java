package springitcasebean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Think on 2018/1/5.
 */
public class hello {
    @Test
    public  void  test(){
//singleton 单例 只会有一个实例
        //prototype 多例 每次创建都是新得对象
        //request web下 对象与request生命周期一致
        //session web下 对象与session生命周期一致
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationcontext.xml");
        user u=(user)ac.getBean("bean.jdbctemplate.user");
        user u2=(user)ac.getBean("bean.jdbctemplate.user");
        user u3=(user)ac.getBean("bean.jdbctemplate.user");
        user u4=(user)ac.getBean("bean.jdbctemplate.user");

      vipuser vu=(vipuser)ac.getBean("vipuser");//自动装在
        System.out.println(u2==u4);//单利模式
        System.out.println(u);
      System.out.println(vu);

    }
}
