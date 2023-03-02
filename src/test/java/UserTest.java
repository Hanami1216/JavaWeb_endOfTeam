import org.junit.Test;
import yokiware.service.UserService;
import yokiware.service.impl.UserServiceImpl;

import java.io.IOException;

/**
 * @Description :
 * @Author : YokiWare
 * @Date: 2023/3/2  14:55
 */
public class UserTest {
    @Test
    public void UserGet() throws IOException {
        UserService userService = new UserServiceImpl();
        System.out.println(userService.getAll());
    }
}
