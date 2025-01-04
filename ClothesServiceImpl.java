package com.louis.service.impl;

import com.louis.bean.Clothes;
import com.louis.service.ClothesService;
import com.louis.utils.BusinessException;
import com.louis.utils.ProductXmlUtils;

import java.util.Collections;
import java.util.List;

public class ClothesServiceImpl implements ClothesService {
    @Override
    public List<Clothes> list() throws BusinessException {
        List<Clothes> clothes = ProductXmlUtils.parserProuductFormXml();
        return clothes;
    }
}
