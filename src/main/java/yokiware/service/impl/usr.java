package yokiware.service.impl;

import yokiware.entity.User;
import yokiware.service.UserService;

import java.io.IOException;
import java.util.List;

/**
 * @Description :
 * @Author : YokeWare
 * @Date: 2023/2/5  13:49
 */
public class usr implements UserService {
    @Override
    public List<User> getAll() throws IOException {
        return null;
    }


    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean delById(int id) {
        return false;
    }

    @Override
    public boolean modifyById(User user) {
        return false;
    }
}
