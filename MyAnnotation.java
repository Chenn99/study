package com.lous;

import java.lang.annotation.*;

/**
 * 自定义注释
 */
//用于生成文档
@Documented
//表示该注解的作用范围在运行时存在
@Retention(RetentionPolicy.RUNTIME)
//用于表示注解的应用范围(类型,方法,属性,构造器,参数,局部变量)
@Target(ElementType.TYPE)
@Inherited
public @interface MyAnnotation {
    //自定义变量
    public String name();
    public String age() default "3";//给变量设置默认值
    public String[] like();//定义一个数组变量
    public Color1 color1();
}
