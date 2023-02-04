package yokiware.service;


import yokiware.entity.User;
import yokiware.mapper.UserMapper;

import java.util.List;

public interface UserService {

    /**
     *获取所有用户信息
     */
    List<User> getAll();

    /**
     * 通过Id获取用户信息
     */
    User getById();

    /**
     * 添加用户
     * @param user
     */
    boolean addUser(User user);

    /**
     * 删除用户通过Id字段
     * @param user
     */
    boolean delById(User user);

    /**
     * 修改用户信息
     * @param user
     */
    boolean modifyById(User user);

}