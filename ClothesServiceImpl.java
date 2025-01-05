package com.louis.service.impl;

import com.louis.bean.Clothes;
import com.louis.service.ClothesService;
import com.louis.utils.BusinessException;
import com.louis.utils.ClothesIO;
import com.louis.utils.ProductXmlUtils;

import java.util.Collections;
import java.util.List;

public class ClothesServiceImpl implements ClothesService {
    private ClothesIO clothesIO = new ClothesIO();
    @Override
    public List<Clothes> list() throws BusinessException {
        List<Clothes> clothes = ProductXmlUtils.parserProuductFormXml();
        return clothes;
    }

    @Override
    public Clothes findById(String cid) throws BusinessException {
        return clothesIO.findById(cid);
    }

    public void update()throws BusinessException{
        clothesIO.update();
    }
}
