package yokiware.mapper;

import org.apache.ibatis.annotations.Param;
import yokiware.entity.User;

import java.util.List;


public interface UserMapper {

    List<User> findAll();


    /**
     * 通过Id获取用户信息
     */
    User getById(@Param("id") int id);

    /**
     * 添加用户
     *
     * @param user
     */
    void addUser(User user);

    /**
     * 删除用户通过Id字段
     *
     * @param user
     */
    void delById(int id);

    /**
     * 修改用户信息
     *
     * @param user
     */
    void modifyById(User user);
}
