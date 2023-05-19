package vueshop.controller.admin;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vueshop.common.Result;
import vueshop.service.admin.orderBackService;

import javax.annotation.Resource;

@Log
@RestController
@RequestMapping("/order")
public class orderBackController {
    @Resource
    orderBackService service;
    @RequestMapping("/getorder")
    public Result getOrder(){
        log.info(String.valueOf(service.getAll()));
        return new Result<>("200",service.getAll());
    }
}
