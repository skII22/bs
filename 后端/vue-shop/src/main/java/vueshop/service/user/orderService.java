package vueshop.service.user;

import vueshop.common.Result;
import vueshop.model.user.Product;

import java.util.List;

public interface orderService {
    Result addOrder(int userId,List<Product> products);
    List getOrder(int userId);
}
