package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 *
 * 例如，当输入5时，应该输出的三角形为：
 *
 * 1 3 6 10 15
 *
 * 2 5 9 14
 *
 * 4 8 13
 *
 * 7 12
 *
 * 11
 *
 *
 * 请注意本题含有多组样例输入。
 *
 * 输入描述:
 * 输入正整数N（N不大于100）
 *
 * 输出描述:
 * 输出一个N行的蛇形矩阵。
 */
public class HJ35 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            StringBuffer str = new StringBuffer();
            int a = 1;
            int b = 0;
            for(int i=0;i<n;i++){
                 a = a +i;
                 b = a;
                for(int j=0;j<n-i;j++){
                    str.append(b+" ");
                    b = b+ j+i+2;
                }
                System.out.println(str.toString().trim());
                str = new StringBuffer();
            }
        }
    }
}