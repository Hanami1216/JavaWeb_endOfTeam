import org.junit.Test;
import yokiware.entity.User;
import yokiware.service.UserService;
import yokiware.service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;


public class UserServiceTest {

    @Test
    public void userGet() throws IOException {

/*        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 执行sql
        //3.1 获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findAll();

        System.out.println(users);
        //4. 释放资源
        sqlSession.close();*/

        UserService userService = new UserServiceImpl();
        List<User> users = userService.getAll();
        System.out.println(users);


    }

    @Test
    public void userDelete() {
        UserService userService = new UserServiceImpl();
        System.out.println(userService.delById(10));
    }

    @Test
    public void userAdd() throws IOException {
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setAddress("花都");
        user.setAge("12");
        user.setName(">");
        user.setPower(1);
        user.setSex("男");
        user.setPassword("12343");
        System.out.println(userService.addUser(user));


    }
}
