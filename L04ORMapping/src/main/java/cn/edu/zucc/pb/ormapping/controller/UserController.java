package cn.edu.zucc.pb.ormapping.controller;

import cn.edu.zucc.pb.ormapping.form.LoginForm;
import cn.edu.zucc.pb.ormapping.service.*;
import cn.edu.zucc.pb.ormapping.view.LoginResult;
import cn.edu.zucc.pb.ormapping.view.User;
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
    @Autowired
    private UserServiceDBV1 userServiceDBV1;
    @Autowired
    private UserServiceDBV2 userServiceDBV2;
    @Autowired
    private UserServiceDBV3 userServiceDBV3;
    @Autowired
    private UserServiceDBV4 userServiceDBV4;

    @GetMapping("/find/{id}")
    @ResponseBody
    public User getById(@PathVariable("id") String id){
        User ret = userService.findById(id);
        return ret;
    }

    @PostMapping("/loginv1")
    @ResponseBody
    public LoginResult loginv1(@RequestBody LoginForm loginForm){
        boolean bLogin = userServiceDBV1.login(loginForm.getLoginName(), loginForm.getPassword());
        return createLoginResult(bLogin);
    }

    @PostMapping("/loginv2")
    @ResponseBody
    public LoginResult loginv2(@RequestBody LoginForm loginForm){
        boolean bLogin = userServiceDBV2.login(loginForm.getLoginName(), loginForm.getPassword());
        return createLoginResult(bLogin);
    }

    @PostMapping("/loginv3")
    @ResponseBody
    public LoginResult loginv3(@RequestBody LoginForm loginForm){
        boolean bLogin = userServiceDBV3.login(loginForm.getLoginName(), loginForm.getPassword());
        return createLoginResult(bLogin);
    }

    @PostMapping("/loginv4")
    @ResponseBody
    public LoginResult loginv4(@RequestBody LoginForm loginForm){
        boolean bLogin = userServiceDBV4.login(loginForm.getLoginName(), loginForm.getPassword());
        return createLoginResult(bLogin);
    }

    private LoginResult createLoginResult(boolean bLogin) {
        LoginResult ret = new LoginResult();
        if(bLogin){
            ret.setLogin(true);
            ret.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        } else {
            ret.setLogin(false);
            ret.setToken("");
        }
        return ret;
    }


}
