package ml.yihao;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * 题目描述
 * 题目描述
 * 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。现在密码学会请你设计一个程序，从已有的N（N为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。
 *
 * 输入:
 *
 * 有一个正偶数N（N≤100），表示待挑选的自然数的个数。后面给出具体的数字，范围为[2,30000]。
 *
 * 输出:
 *
 * 输出一个整数K，表示你求得的“最佳方案”组成“素数伴侣”的对数。
 *
 *
 * 输入描述:
 * 输入说明
 * 1 输入一个正偶数n
 * 2 输入n个整数
 * 注意：数据可能有多组
 *
 * 输出描述:
 * 求得的“最佳方案”组成“素数伴侣”的对数。
 */
public class HJ28 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            int m[] = new int[n];
            int jishu = 0;
            for (int i = 0; i < n; i++) {
                m[i] = scan.nextInt();
                if (m[i] % 2 == 1) jishu++;
            }
            int x[] = new int[jishu];
            int y[] = new int[n - jishu];
            int h = 0;
            int z = 0;
            for (int j = 0; j < n; j++) {
                if (m[j] % 2 == 1) {
                    x[h++] = m[j];
                } else {
                    y[z++] = m[j];
                }
            }
            int sum = 0;
            int xy[][] = new int[jishu][n - jishu];
            for (int j = 0; j < x.length; j++) {
                for (int k = 0; k < y.length; k++) {
                    int friend = x[j] + y[k];
                    boolean flag = true;
                    for (int l = 2; l < friend; l++) {
                        if (friend % l == 0) flag = false;
                    }
                    if (flag == true) {
                        xy[j][k] = 1;
                    }
                }
            }
            boolean ycode[] = new boolean[n - jishu];
            int y_x[] = new int[n - jishu];
            for (int i = 0; i < x.length; i++) {
                if (find(xy, y, ycode, i, y_x)) {
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }

    public static boolean find(int xy[][], int y[], boolean ycode[], int x, int y_x[]) {
        for (int i = 0; i < y.length; i++) {
            if (!ycode[i] && xy[x][i] == 1) {
                ycode[i] = true;
                if (y_x[i] == 0 || find(xy, y, ycode, y_x[i] - 1, y_x)) {
                    y_x[i] = x + 1;
                    ycode[i] = false;
                    return true;
                }
            }
        }
        return false;
    }
}