package ml.yihao;

import java.util.Scanner;

/**
 * 题目描述
 *
 * 输入一个正整数，计算它在二进制下的1的个数。
 * 注意多组输入输出！！！！！！
 * 输入描述:
 * 输入一个整数
 *
 * 输出描述:
 * 计算整数二进制中1的个数
 */
public class HJ62
{

    private int findNumberOf1( int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) count++;
            num = num >>> 1;
        }
        return count;
    } 
    public HJ62() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            int res = findNumberOf1(num);
            System.out.println(res);
        }
    }

    public static void main(String[] args) {
        HJ62 solution = new HJ62();
    }
}