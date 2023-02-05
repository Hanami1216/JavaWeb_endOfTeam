package yokiware.service.impl;


import org.apache.ibatis.session.SqlSession;
import yokiware.entity.User;
import yokiware.mapper.UserMapper;
import yokiware.service.UserService;
import yokiware.util.SqlSessionUtils;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {

    SqlSession sqlSession = SqlSessionUtils.getCurrentSqlSession();

    @Override
    public List<User> getAll() throws IOException {
        //获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        return userMapper.findAll();
    }

    @Override
    public User getById() {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean delById(User user) {
        return false;
    }

    @Override
    public boolean modifyById(User user) {
        return false;
    }
}
