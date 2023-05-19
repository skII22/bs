package vueshop.controller.user;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vueshop.common.Result;
import vueshop.service.user.shoppingcartService;
import java.util.List;
@Log
@RestController
@RequestMapping("/user/shoppingCart")
public class shoppingcartController {
    @Autowired
    shoppingcartService shoppingcartService;
    @RequestMapping("/getShoppingCart")
    public Result getShoppingCart(@RequestBody JSONObject object){
        Integer user_id = object.getInteger("user_id");

        List list = shoppingcartService.getShoppingCart(user_id);
        return new Result("001",list);
    }
    @RequestMapping("/addShoppingCart")
    public Result addShoppingCart(@RequestBody JSONObject object){
        int user_id= object.getInteger("user_id");
        int product_id = object.getInteger("product_id");
       return shoppingcartService.addShoppingCart(user_id,product_id);

    }
    @RequestMapping("/updateShoppingCart")
    public Result updateShoppingCart(@RequestBody JSONObject object){
        int user_id= object.getInteger("user_id");
        int product_id = object.getInteger("product_id");
        Integer num = object.getInteger("num");
        if (num >5){
            return  new Result<>("004",  "数量不合法");
        } else if (num==5) {
            return new Result<>("004", "商品已达到购物限额");
        } else if (num==0) {
            return new Result<>("002", "该商品不在购物车");
        } else {
            return shoppingcartService.updateShoppingCart(user_id,product_id,num);
        }
    }
    @RequestMapping("/deleteShoppingCart")
    public Result deleteShoppingCart(@RequestBody JSONObject object){
        int user_id= object.getInteger("user_id");
        int product_id = object.getInteger("product_id");
        return shoppingcartService.deleteShoppingCart(user_id,product_id);
    }
}
