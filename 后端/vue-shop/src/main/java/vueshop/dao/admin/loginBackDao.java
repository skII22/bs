package vueshop.dao.admin;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface loginBackDao {
    String selectPw();
    int updatePw(String pw);
}
