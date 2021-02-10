package ml.yihao;

import java.util.Scanner;
import java.util.Arrays;

/**
 * 题目描述
 * 输入n个整数，输出其中最小的k个。
 *
 * 本题有多组输入样例，请使用循环读入，比如while(cin>>)等方式处理
 * 输入描述:
 * 第一行输入两个整数n和k
 * 第二行输入一个整数数组
 *
 * 输出描述:
 * 输出一个从小到大排序的整数数组
 */
public class HJ58 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int num = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
             for(int i = 0; i < num; i++){
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}