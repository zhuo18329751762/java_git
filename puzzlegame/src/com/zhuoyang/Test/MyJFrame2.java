package com.zhuoyang.Test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener {
    //创建按钮对象
    JButton jtb=new JButton("点我啊");
    //鼠标监听
    public MyJFrame2(){
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
        //设置按钮位置 宽高
        jtb.setBounds(0,0,100,50);
        //给按钮添加监听
        jtb.addMouseListener(this);
        //将按钮添加到界面中
        this.getContentPane().add(jtb);


        //让界面显示出来
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("鼠标单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("鼠标按下");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("鼠标松开");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("鼠标划入");

    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("鼠标划出");

    }
}
