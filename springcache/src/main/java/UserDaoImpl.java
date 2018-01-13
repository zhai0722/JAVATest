import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Administrator on 2018/1/11.
 */
public class UserDaoImpl implements UserDao {

    //使用Map模拟数据表.
  private  ConcurrentHashMap<String, User> users = new ConcurrentHashMap<String, User>();

    public void add(User user) {
        System.out.println("userdao add user");
        users.put( user.getId(), user);
    }

    public void delete(String id) {
        System.out.println("userdao delete user ");
        users.remove(id);

    }

    public void update(User user) {
        System.out.println("userdao update user");
        users.put(user.getId(),user);
    }

    public User find(String id) {
        System.out.println("userdao find");
        return users.get(id);
    }

    public ConcurrentHashMap<String, User> getAll() {
        System.out.println("userdao getall");
        return users;
    }
}
