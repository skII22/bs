package vueshop.service.user.Impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vueshop.common.Result;
import vueshop.dao.user.orderDao;
import vueshop.model.user.Order;
import vueshop.model.user.Product;
import vueshop.service.user.orderService;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

@Log
@Service
public class orderServiceImpl implements orderService {
    @Autowired
    orderDao orderDao;
    @Override
    @Transactional
    public Result addOrder(int userId,List<Product> products) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        long l = System.currentTimeMillis();
//        int r=new Random().nextInt(100);
//        Long orderId = l+r;

        try {
            for (int i =0;i<products.size();i++){
                int product_id = products.get(i).getProduct_id();

                int product_price = products.get(i).getProduct_price();

                int product_num = products.get(i).getProduct_num();

                orderDao.addOrder(userId,product_id,product_price,product_num,date,l);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new Result("001","购买成功");

    }

    @Override
    public List<Order> getOrder(int userId) {
        List list = new ArrayList();
        LinkedHashSet l = orderDao.getOrder_idList(userId);


            Iterator iterator = l.iterator();

            while (iterator.hasNext()){
                list.add(orderDao.getOrder((BigInteger) iterator.next()));
            }
            log.info(String.valueOf(list));
        return list;
    }
}
