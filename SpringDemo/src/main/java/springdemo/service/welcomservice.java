package springdemo.service;

import org.springframework.stereotype.Service;
import springdemo.dao.userdao;

import javax.annotation.Resource;

/**
 * Created by Think on 2018/1/2.
 */
@Service("ws")
public class welcomservice {
    private String message="helloworld";
    private userdao dao;
    @Resource(name="bean.jdbctemplate.userdao")
    public void setDao(userdao dao) {
        this.dao = dao;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public  void sayhello(){


        System.out.println(message);
        dao.insert();
    }

}
