package vueshop.dao.user;

import org.apache.ibatis.annotations.Mapper;
import vueshop.model.user.User;

@Mapper
public interface userDao {
    User login(String username, String password);
    int findUserName(String username);
    Boolean register(String username,String password);
}
