package com.lous;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注释
 */
//表示该注解的作用范围在运行时存在
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    //自定义变量
    public String name();
    public String age() default "3";//给变量设置默认值
    public String[] like();//定义一个数组变量
    public Color1 color1();
}
