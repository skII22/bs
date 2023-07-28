package vueshop.service.user;

import vueshop.model.user.User;

public interface userService {
    User login(String username, String password);
    Boolean findUserName(String username);
    Boolean register(String username,String password);
}
