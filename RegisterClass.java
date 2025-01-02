package com.louis.ui;

import com.louis.bean.User;
import com.louis.service.UserService;
import com.louis.service.impl.UserServiceImpl;
import com.louis.utils.BusinessException;

public class RegisterClass extends BaseClass{

    public void register() throws BusinessException {
        println(getString("input.username"));
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();

        User user = new User(username,password);
        UserService userService = new UserServiceImpl();
        userService.register(user);

    }
}
