package com.zhuoyang.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class LoginJFrame extends JFrame implements MouseListener {
    //登录界面

    //创建一个集合存储正确的用户名的密码
    static ArrayList<User> list=new ArrayList<User>();
    static {
        list.add(new User("zhangsan","123"));
        list.add(new User("lisi","1234"));
    }
    char[] alphabe={'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
            'O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d',
            'e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t',
            'u','u','w','x','y','z',};
    int[] num={0,1,2,3,4,5,6,7,8,9};
    //登录按钮
    JButton login = new JButton();
    //注册按钮
    JButton register = new JButton();
    String dengLu="puzzlegame\\image\\login\\登录按钮.png";
    String zhuCe="puzzlegame\\image\\login\\注册按钮.png";
    //用户名输入按钮
    JTextField username = new JTextField();
    //密码输入按钮
    JPasswordField password = new JPasswordField();
    //验证码输入框
    JTextField code = new JTextField();
    //验证码
    String codeStr = getYanZhengMa(alphabe, num);
    //正确验证码按钮
    JLabel rightCode = new JLabel();



    public LoginJFrame(){
        //初始化界面
        initJFrame();
        //添加内容
        initView();
        //让界面显示出来
        this.setVisible(true);
    }

    private void initJFrame() {
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
        //取消内部默认布局
        this.setLayout(null);
    }


    //生成验证码
    public  String getYanZhengMa(char[] arr,int[] num){
        Random r=new Random();
        int j=r.nextInt(4);
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if(i!=j){
                sb.append(arr[r.nextInt(arr.length)]);
            }else{
                sb.append(r.nextInt(num.length));
            }
        }
        return sb.toString();
    }
    public void initView() {
        // 1 添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("puzzlegame\\image\\login\\用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);
        // 2 添加用户名输入框

        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);
       // 3 添加密码文字
       JLabel passwordText = new JLabel(new ImageIcon("puzzlegame\\image\\login\\密码.png"));
       passwordText.setBounds(130, 195, 32, 16);
       this.getContentPane().add(passwordText);
       // 4 密码输入框

       password.setBounds(195, 195, 200, 30);
       this.getContentPane().add(password);
       //验证码提示
        JLabel codeText = new JLabel(new ImageIcon("puzzlegame\\image\\login\\验证码.png"));
       codeText.setBounds(133, 256, 50, 30);
       this.getContentPane().add(codeText);
       //验证码输入框
       code.setBounds(195, 256, 100, 30);
       this.getContentPane().add(code);



       //设置内容
       rightCode.setText(codeStr);
       //绑定鼠标事件
        rightCode.addMouseListener(this);
       //设置位置和宽高
       rightCode.setBounds(300, 256, 50, 30);
       //添加到界面
       this.getContentPane().add(rightCode);

       // 5 添加登录按钮

       login.setBounds(123, 310, 128, 47);
       login.setIcon(new ImageIcon(dengLu));
       login.addMouseListener(this);
       //去除按钮的默认边框
       login.setBorderPainted(false);
       //去除按钮的背景
       login.setContentAreaFilled(false);
       this.getContentPane().add(login);
       // 6 添加注册按钮
        register.addMouseListener(this);
       register.setBounds(256, 310, 128, 47);
       register.setIcon(new ImageIcon(zhuCe));
       //去除按钮的默认边框
        register.setBorderPainted(false);
       //去除按钮的背景
        register.setContentAreaFilled(false);
       this.getContentPane().add(register);
        // 7 添加背景图片
        JLabel backGround = new JLabel(new ImageIcon("puzzlegame\\image\\login\\background.png"));
        backGround.setBounds(0, 0, 470, 390);
        this.getContentPane().add(backGround);
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
            //获取用户输入的验证码
            String code = this.code.getText();
            //创建一个User对象
            User userInfo = new User(name, passWord);
            System.out.println("用户输入的用户名为" + name);
            System.out.println("用户输入的密码为" + passWord);
            if (code.length() == 0) {
                showJDialog("验证码不能为空");
            } else if (name.length() == 0 || passWord.length() == 0) {
                System.out.println("用户名或密码为空");
                showJDialog("用户名或密码为空");
            } else if (!code.equals(codeStr)) {
                System.out.println("验证码输入错误");
                showJDialog("验证码输入错误");
            } else if (contains(userInfo)) {
                System.out.println("登陆成功");
                //关闭当前登录界面
                this.setVisible(false);
                new GameJFrame();
            } else {
                showJDialog("密码输入错误");
            }

        } else if (e.getSource() == register) {
            showJDialog("注册功能暂未开放");
        } else if(e.getSource()==rightCode){
            System.out.println("更换验证码");
            String str=getYanZhengMa(alphabe,num);
            rightCode.setText(str);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("鼠标按下");
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("puzzlegame\\image\\login\\登录按下.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("puzzlegame\\image\\login\\注册按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("鼠标松开");
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon(dengLu));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon(zhuCe));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public boolean contains(User user) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals(user.getName())
                    &&list.get(i).getPassWord().equals(user.getPassWord())){
                return true;
            }
        }
        return false;
    }
}
