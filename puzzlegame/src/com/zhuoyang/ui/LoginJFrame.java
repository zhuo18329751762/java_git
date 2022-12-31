package com.zhuoyang.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    //登录界面

    public LoginJFrame(){
        //在创建登录界面时 同时给这个界面设置一些信息
        this.setSize(488,430);
        //设置界面标题
        this.setTitle("拼图  登录");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //让界面显示出来
        this.setVisible(true);
    }
}
