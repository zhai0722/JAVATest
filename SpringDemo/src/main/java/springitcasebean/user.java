package springitcasebean;


import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Think on 2018/1/5.
 */

public class user {
    public user() {
        System.out.println("创建空参构造器");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "bean.jdbctemplate.user{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
