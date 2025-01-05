package com.louis.service;

import com.louis.bean.Order;
import com.louis.utils.BusinessException;

import java.util.List;

public interface OrderService {
    public void buyProduct(Order o)throws BusinessException;
    public List<Order> list() throws BusinessException;
    public Order findById(int orderId) throws BusinessException;
}
