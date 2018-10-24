package examples.daoexam.main;

import examples.daoexam.config.ApplicationConfig;
import examples.daoexam.dao.UserDao;
import examples.daoexam.dto.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class UserInsertTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserDao userDao = ac.getBean(UserDao.class);

        User user = new User();
        user.setEmail("kbs@kbs.co.kr");
        user.setName("kbs");
        user.setPassword("1234");
        user.setRegdate(new Date());
        Long id = userDao.addUser(user);
        System.out.println(id);

        User user1 = userDao.getUser(id);
        System.out.println(user1);

        user1.setName("sbs");
        userDao.updateUser(user1);
        User user2 = userDao.getUser(id);
        System.out.println(user2);

        userDao.deleteUser(id);
        User user3 = userDao.getUser(id);
        if(user3 == null){
            System.out.println("해당 user는 삭제되었습니다");
        }
    }
}
