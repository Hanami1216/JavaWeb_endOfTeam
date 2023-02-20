package yokiware.mapper;

import org.apache.ibatis.annotations.Param;
import yokiware.entity.Oder;

import java.util.List;


public interface OderMapper {

    List<Oder> findAll();


    /**
     * 通过Id获取用户信息
     */
    Oder getById(@Param("id") int id);

    /**
     * 添加用户
     *
     * @param oder
     */
    boolean addUser(Oder oder);

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
     * @param oder
     */
    boolean modifyById(Oder oder);
}
