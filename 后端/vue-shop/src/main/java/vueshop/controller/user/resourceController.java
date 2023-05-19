package vueshop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vueshop.common.Result;
import vueshop.model.user.Carousel;
import vueshop.service.user.resourceService;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class resourceController {
    @Autowired
    resourceService resourceService;
    @RequestMapping("/carousel")
    public Result<Carousel> getCarsousel(){
        List<Carousel> carousel = resourceService.getCarousel();
        return new Result("001",carousel);
    }
    @DeleteMapping("/delete")
    public Result<Carousel> deleteCarousel(String fileUrl){
        System.out.println(fileUrl);
        String s = fileUrl.substring(22);
        resourceService.deleteCarousel(s);
        return new Result<>("200",null);
    }
}
