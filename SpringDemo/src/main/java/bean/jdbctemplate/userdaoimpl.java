package bean.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Think on 2018/1/9.
 */
public class userdaoimpl implements userdao {

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    private JdbcTemplate jt;
    public void save(user u) {
        String sql="insert into t_user values(?,?,?) ";
        jt.update(sql,u.getId(),u.getName(),u.getAge());
    }

    public void delete(Integer id) {
        String sql="delete from t_user where id=? ";
        jt.update(sql,id);
    }

    public void update(user u) {
        String sql="update  t_user set name=? where id=? ";
        jt.update(sql,u.getName(),u.getId());

    }

    public user getByid(Integer id) {
        String sql="select * from t_user where id=?";
        return jt.queryForObject(sql,new RowMapper<user>(){
            public user mapRow(ResultSet rs, int i) throws SQLException {
                user u=new user();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setAge(rs.getInt("age"));




                return u;
            }
        },id);


    }

    public int gettotalcount() {
        String sql="select count(*) from t_user";
        Integer count=jt.queryForObject(sql,Integer.class);
    return count;
    }

    public List<user> getall() {
        String sql="select * from t_user";
          List<user> listu= jt.query(sql, new RowMapper<user>() {
            public user mapRow(ResultSet rs, int i) throws SQLException {
                user u=new user();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setAge(rs.getInt("age"));

                return u;
            }
        });
        return listu;

    }


}
