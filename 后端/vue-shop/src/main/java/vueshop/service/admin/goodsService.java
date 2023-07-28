package vueshop.service.admin;

<<<<<<< HEAD
import com.github.pagehelper.PageInfo;
=======
>>>>>>> 32478a31c06519498ac512df3778dd391cd6f415
import vueshop.model.admin.Product_Detail;

import java.util.List;

public interface goodsService {
<<<<<<< HEAD
    PageInfo getDetail(int page,int pageSize);
=======
    List getDetail();
>>>>>>> 32478a31c06519498ac512df3778dd391cd6f415
    int findId(String name);
    int addPicture(String s,int productId);
    int edit(int id,String image);
    int editName(int id,String name);
    String selectName(int id);
    int delete(List list);
    int deletePhoto(String url);
}
