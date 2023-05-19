package vueshop.service.admin.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vueshop.dao.admin.orderBackDao;
import vueshop.service.admin.orderBackService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class orderBackServiceImpl implements orderBackService {
    @Resource
    orderBackDao dao;

    @Override
    public List getAll() {
        return dao.getAll();
    }
}
