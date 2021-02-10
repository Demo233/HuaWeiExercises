package ml.yihao;

import java.util.Scanner;

/**
 * 题目描述
 * 自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n以内的自守数的个数
 *
 *
 * 接口说明
 * 输入描述:
 * int型整数
 *
 * 输出描述:
 * n以内自守数的数量。
 */
public class HJ99 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int selfHoldNumber = 0;
            for (int i = 0; i <= n; i++) {
                if (((int) Math.pow(i, 2) + "").matches("[0-9]*" + i + "$")) {
                    selfHoldNumber++;
                }
            }
            System.out.println(selfHoldNumber);
        }
    }
}
