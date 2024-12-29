package com.louis.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame2 extends Frame {

    private TextField textField = new TextField(20);
    private Button btn = new Button("¸¶¿î");

    public Frame2(){
        this.setSize(400,200);
        this.setLayout(new FlowLayout());
        this.add(textField);
        this.add(btn);
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String money = textField.getText();
                moneyListener.setMoney(money);
            }
        });
        this.setVisible(true);
    }

    private MoneyListener moneyListener;

    public void setMoneyListener(MoneyListener moneyListener){
        this.moneyListener = moneyListener;
    }

    public static interface MoneyListener{
        public void setMoney(String money);
    }
}
