package com.louis;

import org.junit.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;

public class EnumDemo {

    public static final int RED = 0x1;
    public static final int GREEN = 0x2;
    public static final int BLUE = 0x3;
    public int color;

    @Test
    public void test1(){
        color = RED;
        color = 4;
    }

    public Color colorEnum;
    @Test
    public void test2(){
//        colorEnum = Color.RED;
//        colorEnum = Color.BLUE;
        colorEnum = Color.GREEN;
        System.out.println(colorEnum);
        System.out.println(colorEnum.name());
        System.out.println(colorEnum.ordinal());
        System.out.println(colorEnum.toString());

        Color[] value = Color.values();
        System.out.println(Arrays.toString(value));
    }

    @Test
    public void test3(){

        EnumSet<Color> set = EnumSet.allOf(Color.class);
        for (Color c : set){
            System.out.println(c);
        }
        EnumMap<Color,String> map = new EnumMap<>(Color.class);
        map.put(Color.RED,"red");
        map.put(Color.GREEN,"green");
        map.put(Color.BLUE,"blue");
    }
}
