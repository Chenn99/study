package com.louis.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame implements ActionListener {
    /**
     * 初始化窗体的基本属性
     */
    public MyFrame(){
        this.setSize(600,400);
        this.setTitle("我都第一个GUI窗体");
        //创建一个按钮
        Button button = new Button("请点我一下");
        //给按钮添加单击事件
        button.addActionListener(this);
        //创建一个线性布局
        FlowLayout flowLayout = new FlowLayout();
        //把布局应用到窗体上
        this.setLayout(flowLayout);

        //给窗体添加关闭事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        //把按钮添加到窗体上
        this.add(button);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }

    //单击事件处理的方法
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("获得100元惊喜大礼包");
    }
}
