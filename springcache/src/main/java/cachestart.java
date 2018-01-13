import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Administrator on 2018/1/11.
 */
public class cachestart {

    public static void main(String[] args) {


    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-cache.xml");
    userservice userService = context.getBean("userService", userservice.class);
        System.out.println("service bean: " + userService);
        userService.add(new User("1", "Ilucky1", "pwd1"));
        System.out.println("11111");
         Map<String, User> map =   userService.getAll();
        System.out.println( map.entrySet());
        for( Map.Entry<String, User> entry : map.entrySet()) {
          System.out.println(entry.getValue());
             }

//        ConcurrentHashMap<String, User> map2 = (ConcurrentHashMap<String, User>) userService.getAll();
//      for(ConcurrentHashMap.Entry<String, User> entry : map2.entrySet()) {
//            System.out.println(entry.getValue());
//           }
//        userService.update(new User("1", "Ilucky1_new", "pwd1_new"));
//        ConcurrentHashMap<String, User> map3 = (ConcurrentHashMap<String, User>) userService.getAll();
//         for(ConcurrentHashMap.Entry<String, User> entry : map3.entrySet()) {
//               System.out.println(entry.getValue());
//          }


    }

}
