package vueshop.service.user.Impl;

import lombok.extern.java.Log;
import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vueshop.common.Result;
import vueshop.dao.user.shoppingcartDao;
import vueshop.service.user.shoppingcartService;

import java.util.List;
@Log
@Service
public class shoppingcartServiceImpl implements shoppingcartService {
    @Autowired
    shoppingcartDao shoppingcartDao;
    @Override
    public List getShoppingCart(int userId) {
        return shoppingcartDao.getShoppingCart(userId);
    }

    @Override
    public Result addShoppingCart(int userId, int productId) {

        Integer num = null;
        try {
            num = shoppingcartDao.findShoppingCartNum(userId, productId);
        } catch (BindingException e) {
            num=0;
        }
        if (num.equals(0)){
            shoppingcartDao.addShoppingCart(userId, productId,num+1);
            List list = shoppingcartDao.getShoppingCartByProductId(userId, productId);
            return new Result("001",list,"添加购物车成功!");
        } else if (num.equals(5)) {
            return new Result<>("003","商品已达到购物限额");
        }else{
            shoppingcartDao.updateShoppingCartNum(userId, productId,num+1);
            return new Result<>("002","商品已在购物车,数量+1");
        }

    }

    @Override
    public Result updateShoppingCart(int userId, int productId, int num) {
        if (shoppingcartDao.updateShoppingCartNum(userId,productId,num)==1){
            return new Result<>("001",  "修改购物车数量成功");
        }else {
            return new Result<>("003", "数量没有发生变化");
        }
    }

    @Override
    public Result deleteShoppingCart(int userId, int productId) {
        if (shoppingcartDao.deleteShoppingCart(userId,productId)==1){
            return new Result<>("001", "删除购物车成功");
        }else {
            return new Result<>("002", "该商品不在购物车");
        }
    }
}
