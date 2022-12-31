package com.zhuoyang.Test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame1 extends JFrame implements KeyListener {
    //键盘监听
    public MyJFrame1(){
        //设置界面宽高
        this.setSize(603,680);
        //设置界面标题
        this.setTitle("拼图单机版 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认居中放置 只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);

        this.addKeyListener(this);
        //让界面显示出来
        this.setVisible(true);
    }
    //每一个按键都有一个对应的编号
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开");
        int keyCode = e.getKeyCode();
        if(keyCode==65){
            System.out.println("按下了A");
        }if(keyCode==66){
            System.out.println("按下了B");
        }

    }
}
