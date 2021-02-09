package ml.yihao;

import java.util.Scanner;

/**
 * @author zyh
 * @Description:
 * @date 2021/2/910:44 上午
 * 题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 *
 * 输入描述:
 * 输入一个正浮点数值
 *
 * 输出描述:
 * 输出该数值的近似整数值
 */
public class No7 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        int b = (int)a;

        if( (a-b) >=0.5 ){
            b = (int)(a + 0.5);
        }
        System.out.println(b);
    }
}
