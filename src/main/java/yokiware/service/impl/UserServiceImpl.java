package yokiware.service.impl;


import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import yokiware.entity.User;
import yokiware.mapper.UserMapper;
import yokiware.service.UserService;
import yokiware.util.SqlSessionUtils;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    //获取UserMapper接口的代理对象
    SqlSession sqlSession = SqlSessionUtils.getCurrentSqlSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

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
        if (userMapper.addUser(user)) {
            sqlSession.commit();
            return true;
        } else return false;
    }

    @Override
    public boolean delById(int id) {
        return userMapper.delById(id);
    }

    @Override
    public boolean modifyById(User user) {
        return userMapper.modifyById(user);
    }

}
