package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）沿着各自边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 *
 * 本题含有多组样例输入。
 * 输入描述:
 * 每组样例输入两个正整数n和m，用空格隔开。(1≤n,m≤8)
 *
 * 输出描述:
 * 每组样例输出一行结果
 */
public class HJ91 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num1= sc.nextInt();
            int num2= sc.nextInt();
            System.out.println(methods(num1,num2));
        }
    }

    public static  int methods(int num1,int num2){
        if(num1 == 0 ||num2 == 0){
            return 1;
        }
        return methods(num1-1,num2)+methods(num1,num2-1);
    }

}
