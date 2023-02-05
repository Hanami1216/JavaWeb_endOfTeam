package yokiware.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;

/**
 *
 */
public class SqlSessionUtils {
    //工具类的构造方法都是一般都是私有化的，因为工具类的使用不需要实例化
    private SqlSessionUtils(){
    }

    private static SqlSessionFactory sqlSessionFactory;

    private static ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();

    //类加载的时候，初始化sqlSessionFactory对象，初始化一次
    static {
        try {
            sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取当前线程中的sqlSession对象
     * @return
     */
    public static SqlSession getCurrentSqlSession(){
        SqlSession sqlSession = local.get();
        if(sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();
            local.set(sqlSession);      //将sqlSession绑定到当前线程上
        }
        return sqlSession;
    }
    /**
     * 释放资源
     * @param sqlSession
     */
    public static void close(SqlSession sqlSession){
        if(sqlSession!=null){
            sqlSession.close();
            //重要 接触sqlSession与当前线程的绑定关系
            local.remove(); //tomcat自带线程池，用过的线程t1，下次可能还会使用线程t1
        }
    }
    /**
     * 回滚事务
     * @param sqlSession
     */
    public static void rollback(SqlSession sqlSession){
        if(sqlSession!=null){
            sqlSession.rollback();
        }
    }
}

