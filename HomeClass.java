package com.louis.ui;

public class HomeClass extends BaseClass{

    public void show(){
        showProducts();
    }

    private void showProducts(){

        ConsoleTable t = new ConsoleTable();
        t.appendRow();
        t.appendColumn("id")
                .appendColumn("brand")
                .appendColumn("style")
                .appendColumn("color")
                .appendColumn("size")
                .appendColumn("num")
                .appendColumn("price")
                .appendColumn("description");

        System.out.println(t.toString());
    }
}
