package vueshop.dao.admin;

import org.apache.ibatis.annotations.Mapper;
import vueshop.model.admin.Product_Detail;

import java.util.List;

@Mapper
public interface goodsDao {
    List selectId();
    List selectPicture(int productId);
    String selectName(int productId);
    int findId(String name);
    int addPicture(String s,int productId);
    int edit(int id,String imageUrl);
    int editName(int id,String name);
    void delete(int id);
    void deleteProduct(int id);
    int deletePhoto(String url);
}
