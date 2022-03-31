package com.sonichollow.forum.controller;

import com.sonichollow.forum.entity.User;
import com.sonichollow.forum.service.UserService;
import com.sonichollow.forum.service.ex.NoSuchUsernameException;
import com.sonichollow.forum.service.ex.RepeatUsernameException;
import com.sonichollow.forum.service.ex.ServiceException;
import com.sonichollow.forum.util.Captcha;
import com.sonichollow.forum.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController
public class ControllerTest {

    @Resource
    private UserService userService;

    @RequestMapping("/captcha")
    public JsonResult<Map<String,String>> captcha(){
        return new JsonResult<>(200,"success",userService.getCaptcha());
    }


    @RequestMapping("/register")
    public JsonResult<User> register(String username, String password) {
        User user = new User();
        try {
            user.setUsername(username);
            user.setPassword(password);
            user = userService.register(user);
            return new JsonResult<User>(200, "success", user);
        } catch (ServiceException e) {
            System.err.println(e);
            return new JsonResult<User>(400, "username existed", null);
        }
    }

    @RequestMapping("/login")
    public JsonResult<User> login(String username, String password) {
        User user = new User();
        try {
            user.setUsername(username);
            user.setPassword(password);
            user = userService.login(user);
            return new JsonResult<User>(200, "success", user);
        } catch (ServiceException e) {
            System.err.println(e);
            return new JsonResult<User>(400, "username or password wrong", null);
        }
    }

    @RequestMapping("/find-by-username")
    public JsonResult<User> findByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        user = userService.selectByUsername(username);
        if (user == null) {
            return new JsonResult<User>(400, "not such a user", null);
        }
        if (user.getIsDelete() == 1) {
            return new JsonResult<User>(400, "user logout already", null);
        }
        return new JsonResult<User>(200, "success", user);
    }
}