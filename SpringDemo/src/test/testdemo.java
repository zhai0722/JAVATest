


import bean.jdbctemplate.userdao;
import bean.jdbctemplate.user;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by Think on 2018/1/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:jdbctemplatebeans.xml")
public class testdemo {


    @Resource(name="userdao")
    private userdao ud;

    @Test
    public void test1() throws Exception {

        //0 准备连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/javatest");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        //1 创建JDBC模板对象
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(dataSource);
        //2 书写sql,并执行
        String sql = "insert into t_user values(1,'rose','22') ";
        jt.update(sql);

    }

        @Test
    public  void test2() throws Exception{
        user u=new user();
        u.setId(1);
        u.setName("tom");
        u.setAge(23);
        ud.save(u);
    }




}
