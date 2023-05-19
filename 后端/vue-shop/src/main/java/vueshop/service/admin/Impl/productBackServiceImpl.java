package vueshop.service.admin.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vueshop.common.EnumCategory;
import vueshop.dao.admin.productBackDao;
import vueshop.model.admin.ProductBack;
import vueshop.service.admin.productBackService;

import java.util.List;

@Service
public class productBackServiceImpl implements productBackService {
    @Autowired
    productBackDao dao;

    @Override
    public List getAll() {
        List list = dao.selectAll();
        for (int i = 0; i < list.size(); i++) {
            ProductBack item = (ProductBack) list.get(i);
            item.setImageUrl("http://localhost:3000/"+item.getImageUrl());
        }

        return list;
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
