package erGao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.peer.MouseInfoPeer;
import java.io.IOException;

public class MyJframe extends JFrame implements ActionListener {
    //添加按钮
    JButton JB1=new JButton("帅爆了");
    JButton JB2=new JButton("一般般吧");
    JButton JB3=new JButton("不帅");
    JButton dad=new JButton("饶了我吧!");

    boolean flag=false;



    public MyJframe(){
        initJFrame();
        initView();
        this.setVisible(true);

    }
    //界面初始化
    private void initJFrame() {
        //在创建游戏主界面时 同时给这个界面设置一些信息
        //设置界面宽高
        this.setSize(603, 800);
        //设置界面标题
        this.setTitle("你帅吗");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认居中放置 只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);
    }


    //设置按钮信息
    public void initView(){
        this.getContentPane().removeAll();
        if(flag){
            //展示按钮
            dad.setFont(new Font("微软雅黑",0,30));
            dad.addActionListener(this);
            dad.setBounds(150,50,300,50);
            this.getContentPane().add(dad);
        }
        JLabel text=new JLabel("你觉得自己帅吗?");
        text.setFont(new Font("微软雅黑",0,30));
        text.setBounds(150,150,300,50);
        this.getContentPane().add(text);

        //设置位置和宽高
        JB1.setFont(new Font("微软雅黑",0,30));
        JB1.setBounds(150, 250, 200, 50);
        //设置位置和宽高
        JB2.setFont(new Font("微软雅黑",0,30));
        JB2.setBounds(150, 375, 200, 50);
        //设置位置和宽高
        JB3.setFont(new Font("微软雅黑",0,30));
        JB3.setBounds(150, 500, 200, 50);
        //给三个按钮添加行为监控
        JB1.addActionListener(this);
        JB2.addActionListener(this);
        JB3.addActionListener(this);
        //添加到界面
        this.getContentPane().add(JB1);
        this.getContentPane().add(JB2);
        this.getContentPane().add(JB3);
    }

    //创建弹框
    public void showJDialog(String content){
        //创建一个弹框对象
        JDialog jDialog=new JDialog();
        //给弹窗设置大小
        jDialog.setSize(400,200);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭无法操作下面的界面
        jDialog.setModal(true);
        //创建JLabel对象管理文字并添加到弹框之中
        JLabel warning=new JLabel(content);
        warning.setFont(new Font("微软雅黑",0,20));
        warning.setBounds(0,0,400,300);
        jDialog.getContentPane().add(warning);
        //让弹框显示出来
        jDialog.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==JB1){
            System.out.println("帅爆了");
            showJDialog("你太自信了，给你一点小惩罚");
            try {
                Runtime.getRuntime().exec("shutdown -s -t 300");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            flag=true;
            initView();
        }else if(e.getSource()==JB2){
            System.out.println("一般般");
            showJDialog("你还是太自信了，还要给你一点小惩罚");
            try {
                Runtime.getRuntime().exec("shutdown -s -t 350");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            flag=true;
            initView();
        }else if(e.getSource()==JB3){
            System.out.println("不帅");
            showJDialog("即使这样，还要给你一点小惩罚");
            try {
                Runtime.getRuntime().exec("shutdown -s -t 120");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            flag=true;
            initView();
        }else if(e.getSource()==dad){
            System.out.println("求饶");
            showJDialog("爸爸原谅你了");
            try {
                Runtime.getRuntime().exec("shutdown -a");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
