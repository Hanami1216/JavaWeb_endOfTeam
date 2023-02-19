package yokiware.service.impl;


import yokiware.entity.User;
import yokiware.mapper.UserMapper;
import yokiware.service.UserService;
import yokiware.util.SqlSessionUtils;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {

    //获取UserMapper接口的代理对象
    UserMapper userMapper = SqlSessionUtils.getCurrentSqlSession().getMapper(UserMapper.class);

    @Override
    public List<User> getAll() throws IOException {
        return userMapper.findAll();
    }

    @Override
    public User getById(int id) {
        return userMapper.getById(id);
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean delById(int id) {
        return userMapper.delById(id);
    }

    @Override
    public boolean modifyById(User user) {
        return false;
    }

}
