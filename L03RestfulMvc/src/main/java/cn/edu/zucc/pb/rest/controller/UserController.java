package cn.edu.zucc.pb.rest.controller;

import cn.edu.zucc.pb.rest.form.LoginForm;
import cn.edu.zucc.pb.rest.service.UserService;
import cn.edu.zucc.pb.rest.view.LoginResult;
import cn.edu.zucc.pb.rest.view.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-03-11 17:45
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/find/{id}")
    @ResponseBody
    public User getById(@PathVariable("id") String id){
        User ret = userService.findById(id);
        return ret;
    }

    @PostMapping("/login")
    @ResponseBody
    public LoginResult login(@RequestBody LoginForm loginForm){
        User user = userService.findById(loginForm.getLoginName());
        LoginResult ret = new LoginResult();
        if(user.getPassword().equals(loginForm.getPassword())){
            ret.setLogin(true);
            ret.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        } else {
            ret.setLogin(false);
            ret.setToken("");
        }

        return ret;
    }
}
