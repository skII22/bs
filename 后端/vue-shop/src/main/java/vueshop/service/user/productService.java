package vueshop.service.user;

import com.github.pagehelper.PageInfo;
import vueshop.common.Result;
import vueshop.model.user.Product;

import java.util.List;

public interface productService {
    List<Product> getproduct(String category_name);
    List<Product> getHotProduct(List category_name);
    List getCategory();
    PageInfo<Product> getAllProduct(Integer page, Integer pageSize);
    PageInfo<Product> getProductByCategory(Integer page, Integer pageSize, Integer categoryId);
    PageInfo<Product> getAllProductBySearch(int page, int pageSize, String search);
    Result<Product> getDetails(int productId);
    List<Product> getDetailsPicture(int productId);

}
