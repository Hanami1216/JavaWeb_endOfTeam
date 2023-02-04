package yokiware.mapper;

import org.apache.ibatis.annotations.Mapper;
import yokiware.entity.User;

import java.util.List;


public interface UserMapper {

    List<User> findAll();

}
