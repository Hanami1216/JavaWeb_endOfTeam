package yokiware.service;


import yokiware.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    /**
     *获取所有用户信息
     */
    List<User> getAll() throws IOException;

    /**
     * 通过Id获取用户信息
     */
    User getById(int id);

    /**
     * 添加用户
     * @param user
     */
    boolean addUser(User user);

    /**
     * 删除用户通过Id字段
     *
     * @param
     */
    boolean delById(int id);

    /**
     * 修改用户信息
     * @param user
     */
    boolean modifyById(User user);

}
