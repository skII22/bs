package vueshop.service.admin;

import com.github.pagehelper.PageInfo;
import vueshop.model.admin.Product_Detail;

import java.util.List;

public interface goodsService {
    PageInfo getDetail(int page,int pageSize);
    int findId(String name);
    int addPicture(String s,int productId);
    int edit(int id,String image);
    int editName(int id,String name);
    String selectName(int id);
    int delete(List list);
    int deletePhoto(String url);
}
