package vueshop.dao.user;

import org.apache.ibatis.annotations.Mapper;
import java.util.Date;
import java.util.List;

@Mapper
public interface collectDao {
    List getCollect(int userId);
    List collectExist(int userId);
    int addCollect(int userId, int productId, Date time);
    int deleteCollect(int userId,int productId);
}
