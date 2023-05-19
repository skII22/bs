package vueshop.dao.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

@Mapper
@Transactional
public interface orderDao {
    public int addOrder(int userId, int productId, int price, int num,Date time,Long orderId);
    public  List getOrder(BigInteger orderId);
    public LinkedHashSet getOrder_idList(int userId);

}
