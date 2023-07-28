package vueshop.service.user.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vueshop.dao.user.resourceDao;
import vueshop.model.user.Carousel;
import vueshop.service.user.resourceService;
import java.util.List;
@Service
public class resourceServiceImpl implements resourceService {
    @Autowired
    resourceDao resourceDao;
    @Override
    public List<Carousel> getCarousel() {
        return resourceDao.getResource();
    }

    @Override
    public int addPicture(String s) {
        return resourceDao.addPicture(s);
    }

    @Override
    public int deleteCarousel(String s) {
        return resourceDao.deleteCarousel(s);
    }
}
