package com.zhuoyang.ui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RegisterJFrame extends JFrame implements MouseListener {
    //注册按钮
    JButton login = new JButton();
    //重置按钮
    JButton resetting = new JButton();
    String zhuCe="puzzlegame\\image\\register\\注册按钮.png";
    String chongZhi="puzzlegame\\image\\register\\重置按钮.png";
    //用户名输入框
    JTextField username = new JTextField();
    //密码输入框
    JPasswordField password = new JPasswordField();
    //再次输入密码框
    JPasswordField rePassword = new JPasswordField();
    //所有用户信息
    ArrayList<User> list=new ArrayList<>();

    //注册界面
    public RegisterJFrame(ArrayList<User> list) throws IOException {
        //读取用户信息
        this.list=list;
        //初始化界面
        initJFrame();
        //添加内容
        initView();
        //让界面显示出来
        this.setVisible(true);
        //创建注册界面时 同时给这个界面设置初始值
        this.setSize(488,430);
        //设置界面标题
        this.setTitle("拼图  注册");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //让界面显示出来
        this.setVisible(true);
    }

    private void initView() {
        // 1 添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("puzzlegame\\image\\register\\注册用户名.png"));
        usernameText.setBounds(85, 135, 80, 20);
        this.getContentPane().add(usernameText);
        // 2 添加用户名输入框
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);
        // 3 添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("puzzlegame\\image\\register\\注册密码.png"));
        passwordText.setBounds(97, 193, 70, 20);
        this.getContentPane().add(passwordText);
        // 4 密码输入框
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);
        // 5 添加重新输入密码文字
        JLabel rePasswordText = new JLabel(new ImageIcon("puzzlegame\\image\\register\\再次输入密码.png"));
        rePasswordText.setBounds(73, 251, 100, 20);
        this.getContentPane().add(rePasswordText);
        // 6 重新密码输入框
        rePassword.setBounds(195, 256, 200, 30);
        this.getContentPane().add(rePassword);
        // 7 添加注册按钮
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon(zhuCe));
        login.addMouseListener(this);
        //去除按钮的默认边框
        login.setBorderPainted(false);
        //去除按钮的背景
        login.setContentAreaFilled(false);
        this.getContentPane().add(login);
        // 8 添加重置按钮
        resetting.addMouseListener(this);
        resetting.setBounds(256, 310, 128, 47);
        resetting.setIcon(new ImageIcon(chongZhi));
        //去除按钮的默认边框
        resetting.setBorderPainted(false);
        //去除按钮的背景
        resetting.setContentAreaFilled(false);
        this.getContentPane().add(resetting);
        // 9 添加背景图片
        JLabel backGround = new JLabel(new ImageIcon("puzzlegame\\image\\register\\background.png"));
        backGround.setBounds(0, 0, 470, 390);
        this.getContentPane().add(backGround);
    }

    private void initJFrame() {
        //在创建登录界面时 同时给这个界面设置一些信息
        this.setSize(488,430);
        //设置界面标题
        this.setTitle("拼图  注册");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //取消内部默认布局
        this.setLayout(null);
    }
    //要展示用户名或者密码错误
    public void showJDialog(String content){
        //创建一个弹框对象
        JDialog jDialog=new JDialog();
        //给弹窗设置大小
        jDialog.setSize(200,150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭无法操作下面的界面
        jDialog.setModal(true);
        //创建JLabel对象管理文字并添加到弹框之中
        JLabel warning=new JLabel(content);
        warning.setBounds(0,0,200,150);
        jDialog.getContentPane().add(warning);
        //让弹框显示出来
        jDialog.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("按钮被点击");
        if (e.getSource() == login) {
            String name = username.getText();
            String passWord = password.getText();
            String rePassWord= rePassword.getText();
            System.out.println(name);
            System.out.println(passWord);
            System.out.println(rePassWord);
            if (name.length()==0||passWord.length()==0||rePassWord.length()==0) {
                System.out.println("用户名或密码为空");
                showJDialog("用户名或密码为空");
                return;
            } else if(!passWord.equals(rePassWord)) {
                System.out.println("两次密码不一致");
                showJDialog("两次密码不一致");
                return;
            }
            //创建一个User对象
            User userInfo = new User(name, passWord);
            int index = -1;
            System.out.println(list);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getName());
                  if (list.get(i).getName().equals(name)) {
                    System.out.println("该用户名已被注册");
                    showJDialog("该用户名已被注册");
                    return;
                }
                }
            //将该信息写入文件
                BufferedWriter bw = null;
                try {
                    bw = new BufferedWriter
                            (new FileWriter("puzzlegame\\userinfo.txt", true));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    bw.newLine();
                    bw.write(userInfo.toString());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    bw.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.out.println("用户输入的用户名为" + name);
                System.out.println("用户输入的密码为" + passWord);
                System.out.println("注册成功");
                showJDialog("注册成功");
                try {
                    this.setVisible(false);
                    new LoginJFrame();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
        }
        else if(e.getSource()==resetting){
            password.setText("");
            username.setText("");
            rePassword.setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("鼠标按下");
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("puzzlegame\\image\\register\\注册按下.png"));
        } else if (e.getSource() == resetting) {
            resetting.setIcon(new ImageIcon("puzzlegame\\image\\register\\重置按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("鼠标松开");
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon(zhuCe));
        } else if (e.getSource() == resetting) {
            resetting.setIcon(new ImageIcon(chongZhi));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
