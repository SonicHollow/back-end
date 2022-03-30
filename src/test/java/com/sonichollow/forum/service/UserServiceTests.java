package com.sonichollow.forum.service;

import com.sonichollow.forum.entity.User;
import com.sonichollow.forum.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserService userService;


    @Test
    public void register(){
        try {
            User user=new User();
            user.setUsername("Happy");
            user.setPassword("abcdef");
            userService.register(user);
            System.out.println("注册成功");
        }
        catch (ServiceException e){
            System.err.println(e);
        }
    }

    @Test
    public void loginSuccess(){
        try{
            User user=new User();
            user.setUsername("Happy");
            user.setPassword("123456");
            User selectResult=userService.login(user);
            System.out.println(selectResult);
            System.out.println("登录成功");
        }
        catch (ServiceException e){
            System.err.println(e);
        }
    }

    @Test
    public void loginNoSuchUsername(){
        try{
            User user=new User();
            user.setUsername("Jackie");
            user.setPassword("123456");
            User selectResult=userService.login(user);
            System.out.println(selectResult);
            System.out.println("登录成功");
        } catch (ServiceException e){
            System.err.println(e);
        }

    }

    @Test
    public void loginPasswordWrong(){
        try{
            User user=new User();
            user.setUsername("Jack");
            user.setPassword("12345");
            User selectResult=userService.login(user);
            System.out.println(selectResult);
            System.out.println("登录成功");
        }
        catch (ServiceException e){
            System.err.println(e);
        }
    }

    @Test
    public void updateWithLogin(){
        User user=new User();
        user.setUsername("Jack");
        user.setPassword("123456");
        user.setGender(0);
        user.setEmail("Jack@email.com");
        user.setPhone("18000000000");
        Date date=new Date();
        user.setModifiedTime(date);
        user.setModifiedUser(user.getUsername());
        //需要登录成功
        try{
            userService.login(user);
        }
        catch (ServiceException e){
            System.err.println(e);
        }
        userService.update(user);
        System.out.println("个人信息修改成功");
    }

    @Test
    public void delete(){
        User user=new User();
        user.setUsername("Tom");
        userService.delete(user);
        System.out.println("用户注销成功");
    }

    @Test
    public void updateByAdministrator(){
        User administrator=new User();
        administrator.setUsername("administrator");

        User user=new User();
        String username="Happy";
        user.setUsername(username);
        user.setIsDelete(0);
        String salt=userService.selectByUsername(username).getSalt();
        user.setPassword(userService.rootPassword(salt));
        userService.updateByAdministrator(user,administrator);
        System.out.println("管理员，操作成功");
    }
}
