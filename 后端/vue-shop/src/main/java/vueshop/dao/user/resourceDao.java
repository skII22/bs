package vueshop.dao.user;

import org.apache.ibatis.annotations.Mapper;
import vueshop.model.user.Carousel;
import java.util.List;

@Mapper
public interface resourceDao {
    List<Carousel> getResource();
    int addPicture(String s);

    int deleteCarousel(String s);
}
