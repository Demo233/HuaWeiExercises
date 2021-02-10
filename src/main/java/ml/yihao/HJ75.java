package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
 *
 * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
 *
 * 输入描述:
 * 输入两个只包含小写字母的字符串
 *
 * 输出描述:
 * 输出一个整数，代表最大公共子串的长度
 */
public class HJ75
{
    public int getCommonStrLength(String s, String t) {
        int result = 0;
        for (int j = 0; j < t.length(); j++) {
            for (int i = 0, val = 0; i < s.length() && i + j < t.length(); i++) {
                if (t.charAt(i + j) == s.charAt(i)) {
                    val++;
                    result = Math.max(result, val);
                }
                else {
                    val = 0;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0, val = 0; j < t.length() && i + j < s.length(); j++) {
                if (s.charAt(i + j) == t.charAt(j)) {
                    val++;
                    result = Math.max(result, val);
                }
                else {
                    val = 0;
                }
            }
        }
        return result;
    }

    public HJ75() {
    }

    public static void main(String[] args) 
    {
        HJ75 solution = new HJ75();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String t = in.nextLine();
            int result = solution.getCommonStrLength(s, t);
            System.out.println(result);
        }
    }
}