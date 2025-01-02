package com.louis.service.impl;

import com.louis.bean.User;
import com.louis.service.UserService;
import com.louis.utils.BusinessException;
import com.louis.utils.UserIO;

public class UserServiceImpl implements UserService {

    @Override
    public User register(User user) throws BusinessException {
        UserIO userIO = new UserIO();
        userIO.add(user);
        try{

        }
        userIO.writeUsers();
        return user;
    }
}
