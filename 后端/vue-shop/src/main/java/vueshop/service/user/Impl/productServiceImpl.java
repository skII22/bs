package vueshop.service.user.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vueshop.common.Result;
import vueshop.dao.user.productDao;
import vueshop.model.user.Category;
import vueshop.model.user.Product;
import vueshop.service.user.productService;

import java.util.List;
@Log
@Service
public class productServiceImpl implements productService {
    @Autowired
    productDao productDao;
    @Override
    public List<Product> getproduct(String category_name) {
        return productDao.getproduct(category_name);
    }

    @Override
    public List<Product> getHotProduct(List category_name) {
        return productDao.getHotProduct(category_name);
    }

    @Override
    public List<Category> getCategory() {
        return productDao.getCategory();
    }

    @Override
    public PageInfo<Product> getAllProduct(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Product> list = productDao.getAllProduct();
        PageInfo<Product> PageInfo = new PageInfo<>(list);
        return PageInfo;
    }

    @Override
    public PageInfo<Product> getProductByCategory(Integer page, Integer pageSize, Integer categoryId) {
        PageHelper.startPage(page, pageSize);
        List<Product> list = productDao.getProductByCategory(categoryId);
        PageInfo<Product> PageInfo = new PageInfo<>(list);
        return PageInfo;
    }

    @Override
    public PageInfo<Product> getAllProductBySearch(int page, int pageSize, String search) {
        PageHelper.startPage(page, pageSize);
        List<Product> list = productDao.getProductBySearch(search);
        PageInfo<Product> PageInfo = new PageInfo<>(list);
        return PageInfo;
    }

    @Override
    public List<Product> getDetailsPicture(int productId) {
        return productDao.getDetailsPicture(productId);
    }

    @Override
    public Result<Product> getDetails(int productID) {
        List<Product> list = productDao.getDetails(productID);
        return new Result<Product>("001",list);
    }
}
