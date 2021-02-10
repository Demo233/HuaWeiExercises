package ml.yihao;

import java.util.Scanner;

/**
 * 题目描述
 * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（字符由英文字母和数字0-9组成，不区分大小写。下同）
 * ？：匹配1个字符
 *
 *
 * 输入：
 * 通配符表达式；
 * 一组字符串。
 *
 *
 * 输出：
 *
 * 返回匹配的结果，正确输出true，错误输出false
 *
 * 本题含有多组样例输入！
 * 输入描述:
 * 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
 *
 * 输出描述:
 * 返回匹配的结果，正确输出true，错误输出false
 */
public class HJ71 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String regx = scanner.nextLine();
            String string = scanner.nextLine();
            //做相应的替换
            regx = regx.replaceAll("\\?", "[0-9A-Za-z]{1}");
            regx = regx.replaceAll("\\*", "[0-9A-Za-z]{0,}");
            regx = regx.replaceAll("\\.", "\\\\.");
            boolean result = string.matches(regx);
            System.out.println(result);
        }
    }
}