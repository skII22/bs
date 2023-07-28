package vueshop.dao.admin;

import org.apache.ibatis.annotations.Mapper;
import vueshop.model.admin.ProductBack;

import java.util.List;

@Mapper
public interface productBackDao {
    List selectAll();
    int addPicture(String imageUrl,String name,String price,String title,String intro,String categoryId,String sellPrice,String num);
    int edit(ProductBack p);
    void delete(int id);
    void deletePicture(int id);
    int editPicture(String imageUrl,String name);
    int updatePhoto(String url);
}
