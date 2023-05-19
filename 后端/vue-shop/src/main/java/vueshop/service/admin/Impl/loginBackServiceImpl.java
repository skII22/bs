package vueshop.service.admin.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vueshop.dao.admin.loginBackDao;
import vueshop.service.admin.loginBackService;
@Service
public class loginBackServiceImpl implements loginBackService {
    @Autowired
    loginBackDao dao;
    @Override
    public String selectPw() {
        return dao.selectPw();
    }

    @Override
    public int updatePw(String pw) {
        return dao.updatePw(pw);
    }
}
