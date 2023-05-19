package vueshop.service.user;


import vueshop.model.user.Carousel;

import java.util.List;

public interface resourceService {

    List<Carousel> getCarousel();
    int addPicture(String s);

    int deleteCarousel(String s);
}
