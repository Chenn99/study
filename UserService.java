package com.louis.service;

import com.louis.bean.User;
import com.louis.utils.BusinessException;

public interface UserService {

    User register(User user) throws BusinessException;

}
