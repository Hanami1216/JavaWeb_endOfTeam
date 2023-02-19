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
    boolean addUser(User user);

    /**
     * 删除用户通过Id字段
     *
     * @param id
     * @return
     */
    boolean delById(@Param("id") int id);

    /**
     * 修改用户信息
     *
     * @param user
     */
    boolean modifyById(User user);
}
