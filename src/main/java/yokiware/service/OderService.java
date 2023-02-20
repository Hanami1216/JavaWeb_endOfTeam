package yokiware.service;


import yokiware.entity.Oder;

import java.io.IOException;
import java.util.List;

public interface OderService {

    /**
     * 获取所有用户信息
     */
    List<Oder> getAll() throws IOException;

    /**
     * 通过Id获取用户信息
     */
    Oder getById(int id);

    /**
     * 添加用户
     *
     * @param oder
     */
    boolean addUser(Oder oder);

    /**
     * 删除用户通过Id字段
     *
     * @param
     */
    boolean delById(int id);

    /**
     * 修改用户信息
     *
     * @param oder
     */
    boolean modifyById(Oder oder);

}
