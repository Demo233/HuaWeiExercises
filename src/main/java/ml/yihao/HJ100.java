package ml.yihao;

import java.util.Scanner;

/**
 * 题目描述
 * 功能:等差数列 2，5，8，11，14。。。。
 *
 * 输入:正整数N >0
 *
 * 输出:求等差数列前N项和
 *
 * 本题为多组输入，请使用while(cin>>)等形式读取数据
 *
 * 输入描述:
 * 输入一个正整数。
 *
 * 输出描述:
 * 输出一个相加后的整数。
 */
public class HJ100 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = 2 + 3 * i;
            }
            int sum = 0;
            for (int c : a) {
                sum += c;
            }
            System.out.println(sum);
        }
    }
}

