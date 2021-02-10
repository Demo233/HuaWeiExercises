package ml.yihao;

import java.util.Scanner;

/**
 * @author zyh
 * @Description:
 * @date 2021/2/103:43 下午
 * 题目描述
 * 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。
 *
 *
 * 输入描述:
 * 输入一个字符串，可以有空格
 *
 * 输出描述:
 * 输出逆序的字符串
 */
public class HJ106 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String rts = "";
        for (int i = 0; i < str.length(); i++) {
            rts = str.substring(i, i + 1) + rts;
        }
        System.out.println(rts);
    }
}
