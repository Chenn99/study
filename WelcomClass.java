package com.louis.ui;

import com.louis.utils.BusinessException;

public class WelcomClass extends BaseClass{

    public void statr(){
        println(getString("info.welcome"));
        boolean flag = true;
        while(flag){
            println(getString("info.login.reg"));
            println(getString("info.select"));
            String select = input.nextLine();
            switch (select){
                case "1":
                    flag = false;
                    System.out.println("登录");
                    break;
                case "2":
                    flag = false;
//                    System.out.println("注册");
                    try{
                        new RegisterClass().register();
                        println(getString("reg.success"));
                    }catch (BusinessException e) {
                        println(getString("reg.error"));
                    }
                    break;
                default:
                    println(getString("input.error"));
                    break;
            }

        }
    }

}
