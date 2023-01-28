package com.zhuoyang.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener , ActionListener {

    //定义一个记录步数的变量
    int step=0;
    //定义一个二维数组 存储正确的数据
    int[][] win={
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,0},
    };
    //创建选项下面的条目对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem girl = new JMenuItem("美女");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem sport = new JMenuItem("运动");

    JMenuItem accountItem = new JMenuItem("公众号");
    //记录空白方块在二维数组中的位置
    int x = 0;
    int y = 0;
    //定义一个变量 记录当前显示图片的路径
    String path="puzzlegame\\image\\animal\\animal3\\";
    //创建二维数组
    int[][] arr = new int[4][4];

    //游戏主界面
    public GameJFrame() {
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();
        //初始化数据
        initDate();
        //初始化图片
        initImage();

        //让界面显示出来
        this.setVisible(true);
    }

    //初始化数据
    private void initDate() {
        //把一个一维数组中的数据：0~15 打乱顺序
        //然后按照4个一组的方式添加到二维数组中

        //1.定义一维数组
        int[] temp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //2.打乱数组中的数据
        Random r = new Random();
        for (int i = 0; i < temp.length; i++) {
            int j = r.nextInt(temp.length);
            int a = temp[i];
            temp[i] = temp[j];
            temp[j] = a;
        }
        //3 添加到二维数组中
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            arr[i / 4][i % 4] = temp[i];
        }
    }

    private void initImage() {
        //清空原本存在的图片
        this.getContentPane().removeAll();
        if(victory()){
            //显示胜利图标
            JLabel winJLabel=new JLabel(new ImageIcon("puzzlegame\\image\\win.png"));
            winJLabel.setBounds(203,283,197,73);
            this.getContentPane().add(winJLabel);
        }
        JLabel stepCount=new JLabel("步数"+step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);
        //先加载的图片在上方 后加载的图片在下方
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //获取当前要加载的图片的序号
                int num = arr[i][j];
                //创建一个JLable对象(管理容器)
                JLabel jLabel = new JLabel(new ImageIcon("" +
                        path + num + ".jpg"));
                //指定位置
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel);
            }
        }
        //添加背景图片
        JLabel bg = new JLabel(new ImageIcon(
                "puzzlegame\\image\\background.png"));
        bg.setBounds(40, 40, 508, 560);
        this.getContentPane().add(bg);
        //刷新界面
        this.getContentPane().repaint();
        //创建一个图片ImageIcon的对象
        //ImageIcon icon=new ImageIcon("" +
        //      "D:\\java_git\\puzzlegame\\image\\animal\\animal3\\3.jpg");
    }

    private void initJMenuBar() {
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();
        //创建菜单上面的两个选项的对象(功能 关于我们)
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        JMenu renewalIma = new JMenu("更换图片");



        //将每一个选项下面的条目添加到选项当中
        renewalIma.add(girl);
        renewalIma.add(animal);
        renewalIma.add(sport);
        functionJMenu.add(renewalIma);
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);


        aboutJMenu.add(accountItem);
        //给条目绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        girl.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);
        //将菜单里面的两个选项添加到菜单当中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);
        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //在创建游戏主界面时 同时给这个界面设置一些信息
        //设置界面宽高
        this.setSize(603, 680);
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
        //给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    //按下不松时调用该方法
    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==65){
            //把界面中所有图片删除
            this.getContentPane().removeAll();
            //加载一张完整图片
            JLabel all=new JLabel(new ImageIcon(path+"all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            //加载背景图片
            JLabel bg = new JLabel(new ImageIcon(
                    "puzzlegame\\image\\background.png"));
            bg.setBounds(40, 40, 508, 560);
            this.getContentPane().add(bg);
            //刷新界面
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //判断游戏是否胜利
        if(victory()) {
            //结束方法 如果胜利 不在监控键盘
            initImage();
            return;
        }
            //左；37 上；38 右；39 下；40
            int code = e.getKeyCode();
            if (code == 37) {
                System.out.println("向左移动");
                if (y == 3) {
                    return;
                }
                //x,y表示空白方块
                arr[x][y] = arr[x][y + 1];
                arr[x][y + 1] = 0;
                y++;
                //每移动一次，计步器自增一次
                step++;
                //调用方法 加载新的图片
                initImage();
            } else if (code == 38) {
                System.out.println("向上移动");
                if (x == 3) {
                    return;
                }
                //x,y表示空白方块
                arr[x][y] = arr[x + 1][y];
                arr[x + 1][y] = 0;
                x++;
                //每移动一次，计步器自增一次
                step++;
                //调用方法 加载新的图片
                initImage();
            } else if (code == 39) {
                System.out.println("向右移动");
                if (y == 0) {
                    return;
                }
                //x,y表示空白方块
                arr[x][y] = arr[x][y - 1];
                arr[x][y - 1] = 0;
                y--;
                //每移动一次，计步器自增一次
                step++;
                //调用方法 加载新的图片
                initImage();
            } else if (code == 40) {
                System.out.println("向下移动");
                if (x == 0) {
                    return;
                }
                //x,y表示空白方块
                arr[x][y] = arr[x - 1][y];
                arr[x - 1][y] = 0;
                x--;
                //每移动一次，计步器自增一次
                step++;
                //调用方法 加载新的图片
                initImage();
            } else if (code == 65) {
                //调用方法 加载图片
                initImage();
            } else if (code == 87) {
                arr = new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 0},
                };
                initImage();
        }

        }

    //判断arr数组中的数据和win是否相同
    //如果相同 返回true
    public boolean victory(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]!=win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取点击的条目对象
        Object obj = e.getSource();
        //判断
        if(obj==replayItem){
            System.out.println("重新游戏");
            //打乱二维数组数据
            initDate();
            //计步器清零
            step=0;
            //重新加载图片
            initImage();
        }else if(obj==reLoginItem){
            System.out.println("重新登陆");
            //关闭当前界面
            this.setVisible(false);
            //打开登录界面
            new LoginJFrame();
        }else if(obj==closeItem){
            System.out.println("关闭游戏");
            //直接关闭虚拟机
            System.exit(0);
        }else if(obj==accountItem){
            System.out.println("公众号");
            //创建弹框对象
            JDialog jDialog=new JDialog();
            //创建一个管理图片的容器对象
            JLabel jLabel=new JLabel(new ImageIcon("puzzlegame\\image\\about.png"));
            //设置位置和宽高
            jLabel.setBounds(0,0,258,258);
            //将图片添加到弹框中
            jDialog.getContentPane().add(jLabel);
            //给弹窗设置大小
            jDialog.setSize(344,344);
            //让弹框置顶
            jDialog.setAlwaysOnTop(true);
            //让弹框居中
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭无法操作下面的界面
            jDialog.setModal(true);
            //让弹框显示出来
            jDialog.setVisible(true);
        }else if(obj==girl){
            System.out.println("美女");
            Random r=new Random();
            int i=r.nextInt(13)+1;
            path="puzzlegame\\image\\girl\\girl"+i+"\\";
            //打乱二维数组数据
            initDate();
            //计步器清零
            step=0;
            //重新加载图片
            initImage();
        }
        else if(obj==animal){
            System.out.println("动物");
            Random r=new Random();
            int i=r.nextInt(8)+1;
            path="puzzlegame\\image\\animal\\animal"+i+"\\";
            //打乱二维数组数据
            initDate();
            //计步器清零
            step=0;
            //重新加载图片
            initImage();
        }
        else if(obj==sport){
            System.out.println("运动");
            Random r=new Random();
            int i=r.nextInt(10)+1;
            path="puzzlegame\\image\\sport\\sport"+i+"\\";
            //打乱二维数组数据
            initDate();
            //计步器清零
            step=0;
            //重新加载图片
            initImage();
        }
    }
}
