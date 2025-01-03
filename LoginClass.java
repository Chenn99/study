package com.louis.ui;

import com.louis.bean.User;
import com.louis.service.UserService;
import com.louis.service.impl.UserServiceImpl;
import com.louis.utils.BusinessException;

public class LoginClass extends BaseClass{

    public void login()throws BusinessException{
        println(getString("input.username"));
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();

        UserService userService = new UserServiceImpl();
        User user =new User(username,password);

        if (user!=null){
            curruser = user;
        }else {
            throw new BusinessException("login.error");
        }
    }
}
