package com.zhuoyang.Test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        //把一个一维数组中的数据：0~15 打乱顺序
        //然后按照4个一组的方式添加到二维数组中

        //1.定义一维数组
        int[] temp={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        //2.打乱数组中的数据
        Random r=new Random();
        for (int i = 0; i < temp.length; i++) {
            int j=r.nextInt(temp.length);
            int a=temp[i];
            temp[i]=temp[j];
            temp[j]=a;
        }
        //3 添加到二维数组中
        int[][] arr=new int[4][4];
        for (int i = 0; i < temp.length; i++) {
           arr[i/4][i%4]=temp[i];
            }
    }
}
