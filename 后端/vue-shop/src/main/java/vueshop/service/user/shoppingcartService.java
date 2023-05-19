package vueshop.service.user;

import vueshop.common.Result;

import java.util.List;

public interface shoppingcartService {
    List getShoppingCart(int userId);
    Result addShoppingCart(int userId,int productId);
    Result updateShoppingCart(int userId,int productId,int num);
    Result deleteShoppingCart(int userId,int productId);

}
