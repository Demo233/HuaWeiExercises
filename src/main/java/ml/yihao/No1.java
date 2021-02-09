package ml.yihao;

import java.util.Scanner;

/**
 * @author zyh
 * @Description:
 * @date 2021/2/910:39 上午
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 *
 * 输入描述:
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 *
 * 输出描述:
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 *
 */
public class No1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        int len = s[s.length-1].length();
        System.out.println(len);

    }
}
