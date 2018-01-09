package springdemo.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by Think on 2018/1/2.
 * dao层
 */
@Repository("bean.jdbctemplate.userdao")
public class userdao {
    public  void insert(){
        System.out.println("insert over");

    }
}
