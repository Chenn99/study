package com.louis.service.impl;

import com.louis.bean.Order;
import com.louis.service.OrderService;
import com.louis.utils.BusinessException;

import java.util.Collections;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public void buyProduct(Order o) throws BusinessException {

    }

    @Override
    public List<Order> list() throws BusinessException {
        return Collections.emptyList();
    }

    @Override
    public Order findById(int orderId) throws BusinessException {
        return null;
    }
}
