package vueshop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vueshop.common.Result;
import vueshop.service.admin.loginBackService;

import java.util.*;

@RestController
@RequestMapping("/user")
public class loginBackController {
    @Autowired
    loginBackService service;
    @RequestMapping("/login")
    public Result login(@RequestBody Map<String,String> request) {
        String username = request.get("username");
        String password = request.get("password");
        Map<String, String> res = new HashMap<>();
        res.put("token","admin-token");
        String pw = service.selectPw();
        if (pw.equals(password)){
        return new Result("200",res);
        }else{
        return new Result("400","密码错误");
        }
    }
    @RequestMapping("/getinfo")
    public Result getInfo(@RequestParam String token){
        Map<String, Object> map= new HashMap<>();
        String avatar = "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif";
        String introduction = "I am a super administrator";
        String name = "管理员";
        ArrayList roles= new ArrayList();
        roles.add("admin");
        map.put("avatar",avatar);
        map.put("introduction",introduction);
        map.put("name",name);
        map.put("roles",roles);
        return new Result("200",map);
    }
    @RequestMapping("/logout")
    public Result logout() {
        String data ="success";
        return new Result("200",data);
    }
    @RequestMapping("/changePw")
    public Result changePassword(@RequestBody Map< String,String> map){
        String oldPw = map.get("oldPw");
        String newPw = map.get("newPw");
        String pw = service.selectPw();
        if (pw.equals(oldPw)){
            try {
                service.updatePw(newPw);
            } catch (Exception e) {
                return new Result("200", "系统繁忙");
            }
            return new Result("200", "修改成功");
        }else {
            return new Result("400","原密码不正确请重试");
        }
    }
}
