package bean.jdbctemplate;

import java.util.List;

/**
 * Created by Think on 2018/1/9.
 */

public interface  userdao {

void save(user u);
    void delete(Integer id);
void update(user u);

user getByid(Integer id);
    int gettotalcount();
List<user> getall();



}
