package vueshop.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vueshop.common.Result;
import vueshop.model.user.Product;
import vueshop.service.user.productService;

import java.util.List;

@Log
@RestController
@RequestMapping("/product")
public class productController {
    @Autowired
    productService productService;
    @RequestMapping("/getPromoProduct")
    public Result<Product> getProduct(@RequestBody JSONObject jsonObject){
        String categoryName = jsonObject.getString("categoryName");
        List<Product> getproduct = productService.getproduct(categoryName);
        return new Result("001",getproduct);
    }
    @RequestMapping("/getHotProduct")
    public Result<Product> getHotProduct(@RequestBody JSONObject jsonObject){
        List categoryName = (List) jsonObject.get("categoryName");
        List<Product> list = productService.getHotProduct(categoryName);;
        Result result = new Result("001",list);
        return result;
    }
    @RequestMapping("/getCategory")
    public Result getCategory(){
        List list = productService.getCategory();

        return new Result<>("001",list);
    }
    @RequestMapping("/getAllProduct")
    public PageInfo<Product> getAllProduct(@RequestBody JSONObject jsonObject){
        Integer currentPage = jsonObject.getInteger("currentPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        return productService.getAllProduct(currentPage,pageSize);
    }
    @RequestMapping("/getProductByCategory")
    public PageInfo<Product> getProductByCategory(@RequestBody JSONObject jsonObject){
        Integer currentPage = jsonObject.getInteger("currentPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        Integer categoryId = (Integer) jsonObject.getJSONArray("categoryID").get(0);

        return productService.getProductByCategory(currentPage,pageSize,categoryId);
    }
    @PostMapping ("/getProductBySearch")
    public PageInfo<Product> getProductBySearch(@RequestBody JSONObject jsonObject){
        Integer currentPage = jsonObject.getInteger("currentPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        String Search = jsonObject.getString("search");

        return productService.getAllProductBySearch(currentPage, pageSize, Search);
    }
    @RequestMapping("/getDetails")
    public Result<Product> getDetails(@RequestBody JSONObject jsonObject){
        Integer productID = jsonObject.getInteger("productID");
        return productService.getDetails(productID);
    }
    @RequestMapping("/getDetailsPicture")
    public Result<Product> getDetailsPicture(@RequestBody JSONObject jsonObject){
        Integer productID = jsonObject.getInteger("productID");
        List<Product> list = productService.getDetailsPicture(productID);
        return new Result<>("001",list);
    }
}
