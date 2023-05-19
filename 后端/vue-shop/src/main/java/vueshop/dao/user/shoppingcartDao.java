package vueshop.dao.user;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface shoppingcartDao {
    List getShoppingCart(int userId);
    void addShoppingCart(int userId,int productId,int num);
    int findShoppingCartNum(int userId,int productId);
    int updateShoppingCartNum(int userId,int productId,int num);
    List getShoppingCartByProductId(int userId,int productId);
    int deleteShoppingCart(int userId,int productId);
}
