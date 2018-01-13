import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2018/1/11.
 */
public class userserviceImpl implements userservice {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @CacheEvict(value = "data", allEntries = true)
    public void add(User user) {
        System.out.println("userservice:add user");
        userDao.add(user);
    }

    @CacheEvict(value = "data", allEntries = true)
    public void delete(String id) {
        System.out.println("userservice:delete user");
        userDao.delete(id);
    }

    @CacheEvict(value = "data", allEntries = true)
    public void update(User user) {
        System.out.println("userservice:update user");
        userDao.update(user);
    }

    @Cacheable(value = "data")
    public User find(String id) {
        System.out.println("userservice:find user");
        return userDao.find(id);
    }

    @Cacheable(value = "data")
    public ConcurrentHashMap<String, User> getAll() {
        System.out.println("userservice:getAll user");
        return userDao.getAll();
    }
}
