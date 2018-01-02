package springmybatis.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Think on 2018/1/2.
 */

public class testDatasource {
    @Test
    public void testconnect(){
        ApplicationContext ac =new ClassPathXmlApplicationContext("beans.xml");
        DataSource ds=(DataSource)ac.getBean("datasource");
        try {
            System.out.println(ds.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
