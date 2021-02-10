package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 *
 * 例如：
 *
 * 1^3=1
 *
 * 2^3=3+5
 *
 * 3^3=7+9+11
 *
 * 4^3=13+15+17+19
 *
 * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
 * 本题含有多组输入数据。
 *
 * 输入描述:
 * 输入一个int整数
 *
 * 输出描述:
 * 输出分解后的string
 */
public class HJ76 {
    public static void main(String[] arg){
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            String input=s.nextLine();
            int count=Integer.parseInt(input);
            int initCount=count*(count-1)-1;
            for(int i=0;i<count;i++){
                initCount=initCount+2;
                if(i==count-1){
                    System.out.print(initCount);
                }else
                System.out.print(initCount+"+");
            }
            System.out.println();
        }
    }
}