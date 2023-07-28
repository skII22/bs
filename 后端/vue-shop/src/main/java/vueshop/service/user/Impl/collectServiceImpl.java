package vueshop.service.user.Impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vueshop.common.Result;
import vueshop.dao.user.collectDao;
import vueshop.service.user.collectService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Transactional
@Service
@Log
public class collectServiceImpl implements collectService {
    @Autowired
    collectDao collectDao;
    @Override
    public List getCollect(int userId) {
        List list = collectDao.getCollect(userId);
        return collectDao.getCollect(userId);
    }
    @Override
    public int addCollect(int userId, int productId) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = new Date(System.currentTimeMillis());
//        System.out.println(formatter.format(date));
        return collectDao.addCollect(userId, productId,date);
    }

    @Override
    public List getCollectsEx(int userId) {
        return collectDao.collectExist(userId);
    }

    @Override
    public Result deleteCollect(int userId, int productId) {
        int i = 0;
        try {
            i = collectDao.deleteCollect(userId, productId);
        } catch (Exception e) {
            i=10;
        }
        if (i==1){
            return new Result("001","删除收藏成功");
        }else if (i==10){
            return new Result<>("004","未知错误");
        }else {
            return new Result<>("002","该商品不在收藏列表");
        }
    }
}
