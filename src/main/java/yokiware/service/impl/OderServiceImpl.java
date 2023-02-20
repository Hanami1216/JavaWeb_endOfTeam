package yokiware.service.impl;


import org.apache.ibatis.session.SqlSession;
import yokiware.entity.Oder;
import yokiware.mapper.OderMapper;
import yokiware.service.OderService;
import yokiware.util.SqlSessionUtils;

import java.io.IOException;
import java.util.List;

public class OderServiceImpl implements OderService {
    //获取UserMapper接口的代理对象
    SqlSession sqlSession = SqlSessionUtils.getCurrentSqlSession();
    OderMapper oderMapper = sqlSession.getMapper(OderMapper.class);

    @Override
    public List<Oder> getAll() throws IOException {
        return oderMapper.findAll();
    }

    @Override
    public Oder getById(int id) {
        return oderMapper.getById(id);
    }

    @Override
    public boolean addUser(Oder oder) {
        if (oderMapper.addUser(oder)) {
            sqlSession.commit();
            return true;
        } else return false;
    }

    @Override
    public boolean delById(int id) {
        if (oderMapper.delById(id)) {
            sqlSession.commit();
            return true;
        } else return false;
    }

    @Override
    public boolean modifyById(Oder oder) {
        if (oderMapper.modifyById(oder)) {
            sqlSession.commit();
            return true;
        } else return false;
    }

}
