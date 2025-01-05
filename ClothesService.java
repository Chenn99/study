package com.louis.service;

import com.louis.bean.Clothes;
import com.louis.utils.BusinessException;

import java.util.List;

public interface ClothesService {

    public List<Clothes> list() throws BusinessException;
    public Clothes findById(String cid) throws BusinessException;
    public void update()throws BusinessException;
}
