package vueshop.service.admin;

import vueshop.model.admin.ProductBack;

import java.util.List;

public interface productBackService {
    List getAll();
    int addPicture(String imageUrl,String name,String price,String title,String intro,String categoryId,String sellPrice,String num);
    int edit(ProductBack pback);
    int delete(List list);
    int editPicture(String imageUrl,String name);
    int deletePhoto(String url);
}
