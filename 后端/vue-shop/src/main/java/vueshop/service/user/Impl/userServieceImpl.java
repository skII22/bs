package vueshop.service.user.Impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vueshop.dao.user.userDao;
import vueshop.model.user.User;
import vueshop.service.user.userService;

@Log
@Service
public class userServieceImpl implements userService {
    @Autowired
    userDao userDao;
    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }

    @Override
    public Boolean findUserName(String username) {
        if (userDao.findUserName(username)==0){
            return true;
        }else {
        return false;
        }
    }

    @Override
    public Boolean register(String username, String password) {

        try {
            if (userDao.register(username, password)) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }
}
