package ml.yihao;

import java.util.Scanner;

/**
 * @author zyh
 * @Description:
 * @date 2021/2/910:47 上午
 * 题目描述
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 *
 * 输入描述:
 * 输入一个int整数
 *
 * 输出描述:
 * 将这个整数以字符串的形式逆序输出
 */
public class No11 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        StringBuffer sb = new StringBuffer(a + "");
        System.out.println(sb.reverse());

    }
}
