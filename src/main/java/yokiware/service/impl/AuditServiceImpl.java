package yokiware.service.impl;


import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import yokiware.entity.Audit;
import yokiware.mapper.AuditMapper;
import yokiware.service.AuditService;
import yokiware.util.SqlSessionUtils;

import java.util.List;

public class AuditServiceImpl implements AuditService {

    private static final Logger logger = Logger.getLogger(AuditServiceImpl.class);
    //获取UserMapper接口的代理对象
    SqlSession sqlSession = SqlSessionUtils.getCurrentSqlSession();
    AuditMapper auditMapper = sqlSession.getMapper(AuditMapper.class);

    @Override
    public List<Audit> getAll() {
        return auditMapper.findAll();
    }

    @Override
    public Audit getById(int id) {
        return auditMapper.getById(id);
    }

    @Override
    public boolean addAudit(Audit audit) {
        if (auditMapper.addAudit(audit)) {
            sqlSession.commit();
            return true;
        } else return false;
    }

    @Override
    public boolean delById(int id) {
        if (auditMapper.delById(id)) {
            sqlSession.commit();
            return true;
        } else return false;
    }

    @Override
    public boolean modifyById(Audit audit) {
        if (auditMapper.modifyById(audit)) {
            sqlSession.commit();
            return true;
        } else return false;
    }

}
