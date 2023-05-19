package vueshop.controller.user;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vueshop.common.Result;
import vueshop.service.user.collectService;

import java.util.List;

@RestController
@RequestMapping("/user/collect")
public class collectController {
    @Autowired
    collectService service;
    @RequestMapping("/getCollect")
    public Result getCollect(@RequestBody JSONObject object){
        Integer user_id = object.getInteger("user_id");
        List list = service.getCollect(user_id);
        if (!list.equals(null)){
            return new Result("001",list);
        }else {
            return new Result<>("002","该用户没有收藏的商品");
        }
    }

    @RequestMapping("/addCollect")
    public Result addCollect(@RequestBody JSONObject object){
        Integer user_id = object.getInteger("user_id");
        Integer product_id = object.getInteger("product_id");
        List ex = service.getCollectsEx(user_id);
        if (!ex.contains(product_id)){
            service.addCollect(user_id, product_id);
            return new Result("001","添加收藏成功");
        }else if (ex.contains(product_id)){
            return new Result<>("003","该商品已经添加收藏，请到我的收藏查看");
        }else {
            return new Result<>("004","未知错误");
        }

    }


    @RequestMapping("/deleteCollect")
    public Result deleteCollect(@RequestBody JSONObject object){
        Integer user_id = object.getInteger("user_id");
        Integer product_id = object.getInteger("product_id");
        return service.deleteCollect(user_id,product_id);
    }
}
