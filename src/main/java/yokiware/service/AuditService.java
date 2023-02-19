package yokiware.service;


import yokiware.entity.Audit;

import java.io.IOException;
import java.util.List;

public interface AuditService {

    /**
     * 获取所有用户信息
     */
    List<Audit> getAll() throws IOException;

    /**
     * 通过Id获取用户信息
     */
    Audit getById(int id);

    /**
     * 添加用户
     *
     * @param audit
     */
    boolean addAudit(Audit audit);

    /**
     * 删除用户通过Id字段
     *
     * @param
     */
    boolean delById(int id);

    /**
     * 修改用户信息
     *
     * @param audit
     */
    boolean modifyById(Audit audit);

}
