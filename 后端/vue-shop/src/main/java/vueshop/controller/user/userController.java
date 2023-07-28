package vueshop.controller.user;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import vueshop.common.Result;
import vueshop.model.user.User;
import vueshop.service.user.userService;

import javax.servlet.http.HttpSession;

@Log
@RestController
@SessionAttributes(names = {"name2"},types = {Result.class})
public class userController {
    @Autowired
    userService userService;
    @RequestMapping("/users/login")
    public Result<User> login(@RequestBody JSONObject object ,HttpSession session){
        String userName = object.getString("userName");
        String password = object.getString("password");
        User user = userService.login(userName, password);

        if (user.equals(null)){
            return new Result<>("004",null,"用户名或密码错误");
        }
        session.setAttribute("user",user);
        return new Result<>("001",user,"登录成功");
    }
<<<<<<< HEAD
    @RequestMapping("/users/logout")
    public Result<User> logout(HttpSession session){
        session.removeAttribute("user");
        return new Result<>("001",null,"登录已退出");
    }
=======
>>>>>>> 32478a31c06519498ac512df3778dd391cd6f415
    @RequestMapping("/users/findUserName")
    public Result<User> findUserName(@RequestBody JSONObject object){
        String userName = object.getString("userName");
        if (userService.findUserName(userName)){
            return new Result<>("001",null,"用户名不存在可以注册");
        }else {
            return new Result<>("004",null,"用户名已经存在不能注册");
        }
    }
    @RequestMapping("/users/register")
    public Result<User> register(@RequestBody JSONObject object){
        String userName = object.getString("userName");
        String password = object.getString("password");
        if (userService.register(userName,password)) {
            return new Result<>("001",null,"注册成功");
        }else {
            return new Result<>("004",null,"用户已存在，不能注册");
        }
    }

}
