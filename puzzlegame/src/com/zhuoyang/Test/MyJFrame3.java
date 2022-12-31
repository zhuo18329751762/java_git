package com.zhuoyang.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame3 extends JFrame implements ActionListener{
    //创建按钮对象
    JButton jtb1=new JButton("点我啊");
    JButton jtb2=new JButton("点我");
    public MyJFrame3(){
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
        jtb1.setBounds(0,0,100,50);
        jtb2.setBounds(100,0,100,50);
        jtb2.addActionListener(this);
        //给按钮添加动作监听
        //jtb.addActionListener(new MyActionListener());
        //使用匿名内部类
//        jtb.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("被点击");
//            }
//        });
        jtb1.addActionListener(this);
        //将按钮添加到界面之中
        this.getContentPane().add(jtb1);
        this.getContentPane().add(jtb2);

        //让界面显示出来
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取当前操作的那个按钮对象
        Object source = e.getSource();
        if(source==jtb1){
            jtb1.setSize(200,200);
        }else if(source==jtb2){
            Random r=new Random();
            jtb2.setLocation(r.nextInt(500),r.nextInt(500));
        }
    }
}
