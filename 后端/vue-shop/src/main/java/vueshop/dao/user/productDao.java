package vueshop.dao.user;

import org.apache.ibatis.annotations.Mapper;
import vueshop.model.user.Category;
import vueshop.model.user.Product;

import java.util.List;

@Mapper
public interface productDao {
    List<Product> getproduct(String category_name);
    List<Product> getHotProduct(List category_name);
    List<Category> getCategory();
    List<Product> getAllProduct();
    List<Product> getProductByCategory(Integer id);
    List<Product> getProductBySearch(String search);
    List<Product> getDetails(int id);
    List<Product> getDetailsPicture(int id);
}
