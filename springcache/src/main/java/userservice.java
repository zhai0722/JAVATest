import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Administrator on 2018/1/11.
 */
public interface userservice {

    public abstract void add(User user);

    public abstract void delete(String id);

  public abstract void update(User user);

 public abstract User find(String id);

  public abstract ConcurrentMap<String, User> getAll();



}
