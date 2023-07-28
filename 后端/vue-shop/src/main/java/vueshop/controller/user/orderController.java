package vueshop.controller.user;



import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vueshop.common.Result;
import vueshop.model.user.Product;
import vueshop.service.user.orderService;

import java.util.List;

@Log
@RestController
@RequestMapping("/user/order")
public class orderController {
    @Autowired
    orderService orderService;
    @RequestMapping("/addOrder")
    public Result addOrder(@RequestBody JSONObject object){
        Integer user_id = object.getInteger("user_id");
        List<Product> products = object.getObject("products", new TypeReference<List<Product>>() {});
        try {
           return orderService.addOrder(user_id, products);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>("002","购买失败");
        }

    }
    @RequestMapping("/getOrder")
    public Result getOrder(@RequestBody JSONObject object){
        int userId = object.getInteger("user_id");
        if (orderService.getOrder(userId).equals(null)){
            return new Result<>("002","该用户没有订单信息");
        }else {
            return new Result<>("001",orderService.getOrder(userId));
        }
    }
}
