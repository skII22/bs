package vueshop.service.admin;

<<<<<<< HEAD
import com.github.pagehelper.PageInfo;
=======
>>>>>>> 32478a31c06519498ac512df3778dd391cd6f415
import vueshop.model.admin.ProductBack;

import java.util.List;

public interface productBackService {
<<<<<<< HEAD
    PageInfo getAll(int page, int pageSize);
=======
    List getAll();
>>>>>>> 32478a31c06519498ac512df3778dd391cd6f415
    int addPicture(String imageUrl,String name,String price,String title,String intro,String categoryId,String sellPrice,String num);
    int edit(ProductBack pback);
    int delete(List list);
    int editPicture(String imageUrl,String name);
    int deletePhoto(String url);
}
