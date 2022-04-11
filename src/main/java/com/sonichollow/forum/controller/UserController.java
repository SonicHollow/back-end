package com.sonichollow.forum.controller;


import com.sonichollow.forum.entity.User;
import com.sonichollow.forum.service.UserService;
import com.sonichollow.forum.service.ex.ServiceException;
import com.sonichollow.forum.util.JsonResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;


@RestController
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView mav=new ModelAndView("welcome.html");
        mav.getModel().put("message","This is Home Page");
        return mav;
    }


    @RequestMapping("/welcome")
    public ModelAndView test(){
        ModelAndView mav=new ModelAndView("welcome.html");
        mav.getModel().put("message","Hello World");
        return mav;
    }

//    @RequestMapping("/captcha")
//    public JsonResult<Map<String,String>> captcha(){
//        return new JsonResult<>(200,"success",userService.getCaptcha());
//    }

    @RequestMapping("/captcha")
    public ModelAndView captcha(){
        ModelAndView mav=new ModelAndView("captcha.html");
        mav.getModel().put("state",200);
        mav.getModel().put("message","success");
        mav.getModel().put("captcha",userService.getCaptcha());
        return mav;
    }


    @RequestMapping("/register")
    public ModelAndView register(String username, String password) {
        ModelAndView mav=new ModelAndView("welcome.html");
        User user = new User();
        try {
            user.setUsername(username);
            user.setPassword(password);
            user = userService.register(user);
            //return new JsonResult<User>(200, "success", user);
            mav.getModel().put("state",200);
            mav.getModel().put("message",username);
            mav.getModel().put("user",user);
            return mav;
        } catch (ServiceException e) {
            System.err.println(e);
            mav.getModel().put("state",400);
            mav.getModel().put("message","username existed");
            return mav;
        }
    }

//    @RequestMapping("/register")
//    public JsonResult<User> register(String username, String password) {
//        User user = new User();
//        try {
//            user.setUsername(username);
//            user.setPassword(password);
//            user = userService.register(user);
//            return new JsonResult<User>(200, "success", user);
//        } catch (ServiceException e) {
//            System.err.println(e);
//            return new JsonResult<User>(400, "username existed", null);
//        }
//    }

    @RequestMapping("/login")
    public ModelAndView login(String username, String password) {
        ModelAndView mav=new ModelAndView("welcome.html");
        User user = new User();
        try {
            user.setUsername(username);
            user.setPassword(password);
            user = userService.login(user);
            mav.getModel().put("state",200);
            mav.getModel().put("message","success login");
            mav.getModel().put("user",username);
            return mav;
            //return new JsonResult<User>(200, "success", user);
        } catch (ServiceException e) {
            System.err.println(e);
            mav.getModel().put("state",400);
            mav.getModel().put("message","username or password wrong");
            mav.getModel().put("user",null);
            return mav;
        }
    }

//    @RequestMapping("/login")
//    public JsonResult<User> login(String username, String password) {
//        User user = new User();
//        try {
//            user.setUsername(username);
//            user.setPassword(password);
//            user = userService.login(user);
//            return new JsonResult<User>(200, "success", user);
//        } catch (ServiceException e) {
//            System.err.println(e);
//            return new JsonResult<User>(400, "username or password wrong", null);
//        }
//    }

    @RequestMapping("/find-by-username")
    public ModelAndView findByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        user = userService.selectByUsername(username);
        ModelAndView mav=new ModelAndView("welcome.html");
        if (user == null) {
            mav.getModel().put("state",400);
            mav.getModel().put("message","not such a user");
            mav.getModel().put("user",null);
            return mav;
        }
        if (user.getIsDelete() == 1) {
            mav.getModel().put("state",400);
            mav.getModel().put("message","user deleted already");
            mav.getModel().put("user",null);
            return mav;
        }
        mav.getModel().put("state",200);
        mav.getModel().put("message","success login");
        mav.getModel().put("user",username);
        return mav;
    }

//    @RequestMapping("/find-by-username")
//    public JsonResult<User> findByUsername(String username) {
//        User user = new User();
//        user.setUsername(username);
//        user = userService.selectByUsername(username);
//        if (user == null) {
//            return new JsonResult<User>(400, "not such a user", null);
//        }
//        if (user.getIsDelete() == 1) {
//            return new JsonResult<User>(400, "user logout already", null);
//        }
//        return new JsonResult<User>(200, "success", user);
//    }

    @RequestMapping("/delete")
    public ModelAndView deleteByUsername(String username) {
        ModelAndView mav=new ModelAndView("welcome.html");
        User user = new User();
        user.setUsername(username);
        userService.delete(user);
        mav.getModel().put("state",200);
        mav.getModel().put("message","success deleted");
        mav.getModel().put("user",null);
        return mav;
    }
}