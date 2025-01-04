package com.louis.service;

import com.louis.bean.Clothes;
import com.louis.utils.BusinessException;

import java.util.List;

public interface ClothesService {

    public List<Clothes> list() throws BusinessException;
}
