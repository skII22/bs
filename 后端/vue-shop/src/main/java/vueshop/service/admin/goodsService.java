package vueshop.service.admin;

import vueshop.model.admin.Product_Detail;

import java.util.List;

public interface goodsService {
    List getDetail();
    int findId(String name);
    int addPicture(String s,int productId);
    int edit(int id,String image);
    int editName(int id,String name);
    String selectName(int id);
    int delete(List list);
    int deletePhoto(String url);
}
