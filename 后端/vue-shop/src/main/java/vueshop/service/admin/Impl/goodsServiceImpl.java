package vueshop.service.admin.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vueshop.dao.admin.goodsDao;
import vueshop.model.admin.Product_Detail;
import vueshop.service.admin.goodsService;
import java.util.ArrayList;
import java.util.List;

@Log
@Service
public class goodsServiceImpl implements goodsService {
    @Autowired
    goodsDao dao;

    @Override
    public PageInfo getDetail(int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        List list = dao.selectId();
        List ob = new ArrayList();
        for (int i =0;i<list.size(); i++) {
            String id = String.valueOf(list.get(i));
            Product_Detail detail = new Product_Detail();
            detail.setId(Integer.parseInt(id));
            detail.setName(dao.selectName(Integer.parseInt(id)));
            List l = dao.selectPicture(Integer.parseInt(id));

            l.replaceAll(item -> "http://localhost:81/" + item);
            log.info(String.valueOf(l));
            detail.setImageUrl(l);
            ob.add(detail);
        }
        PageInfo info = new PageInfo<>(ob);
        return info;
    }

    @Override
    public int findId(String name) {
        return dao.findId(name);
    }

    @Override
    public int addPicture(String s,int productId) {
        return dao.addPicture(s,productId);
    }

    @Override
    public int edit(int id,String image) {
        dao.edit(id,image);
        return 1;
    }

    @Override
    public int editName(int id, String name) {
        dao.editName(id, name);
        return 0;
    }

    @Override
    public String selectName(int id) {
        return dao.selectName(id);
    }
    @Override
    public int delete(List list){
        list.forEach(i->{
            try {
                dao.deleteProduct((Integer)i);
                dao.delete((Integer) i);
            } catch (Exception e) {
                throw e;
            }
        });
        return 1;
    }

    @Override
    public int deletePhoto(String url) {
        return dao.deletePhoto(url);
    }
}
