package vueshop.service.admin.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vueshop.dao.admin.productBackDao;
import vueshop.model.admin.ProductBack;
import vueshop.service.admin.productBackService;
import java.util.List;

@Service
public class productBackServiceImpl implements productBackService {
    @Autowired
    productBackDao dao;

    @Override
    public PageInfo getAll(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List list = dao.selectAll();
        for (int i = 0; i < list.size(); i++) {
            ProductBack item = (ProductBack) list.get(i);
            item.setImageUrl("http://localhost:81/"+item.getImageUrl());
        }
        PageInfo info = new PageInfo<>(list);
        return info;
    }

    @Override
    public int addPicture(String imageUrl, String name, String price, String title, String intro, String categoryId, String sellPrice, String num) {
        return dao.addPicture(imageUrl,name,price,title,intro,categoryId,sellPrice,num);
    }

    @Override
    public int edit(ProductBack pback) {
        System.out.println(pback.getId());
        return dao.edit(pback);
    }

    @Override
    public int delete(List list){
        list.forEach(i->{
            try {
                dao.deletePicture((Integer)i);
                dao.delete((Integer) i);
            } catch (Exception e) {
                throw e;
            }
        });
        return 1;
    }

    @Override
    public int editPicture(String imageUrl, String name) {
        return dao.editPicture(imageUrl,name);
    }

    @Override
    public int deletePhoto(String url) {
        return dao.updatePhoto(url);
    }
}
