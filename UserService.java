package com.louis.service;

import com.louis.bean.User;
import com.louis.utils.BusinessException;

public interface UserService {

    public User register(User user) throws BusinessException;

    public User login(String username,String password) throws BusinessException;
}
