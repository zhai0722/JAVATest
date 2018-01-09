package springdemo.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springdemo.service.welcomservice;

/**
 * Created by Think on 2018/1/2.
 */

public class app {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("jdbctemplatebeans.xml");
        welcomservice ws= (welcomservice) ac.getBean("ws");
        ws.sayhello();
    }
}
