package com.louis.test;

import com.louis.bean.Clothes;
import com.louis.utils.ProductXmlUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ProductsXmlUtilsTest {

    @Test
    public void test(){
        List<Clothes> clothes = ProductXmlUtils.parserProuductFormXml();
        System.out.println(Arrays.toString(clothes.toArray()));
    }
}
