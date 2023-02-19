package yokiware.mapper;

import org.apache.ibatis.annotations.Param;
import yokiware.entity.Audit;

import java.util.List;


public interface AuditMapper {

    List<Audit> findAll();


    /**
     * 通过Id获取用户信息
     */
    Audit getById(@Param("id") int id);

    /**
     * 添加用户
     *
     * @param audit
     */
    boolean addAudit(Audit audit);

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
     * @param audit
     */
    boolean modifyById(Audit audit);
}
