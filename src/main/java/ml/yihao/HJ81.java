package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 判断短字符串中的所有字符是否在长字符串中全部出现。
 * 请注意本题有多组样例输入。
 *
 *
 *
 * 输入描述:
 * 输入两个字符串。第一个为短字符串，第二个为长字符串。两个字符串均由小写字母组成。
 *
 * 输出描述:
 * 如果短字符串的所有字符均在长字符串中出现过，则输出true。否则输出false。
 */
public class HJ81 {

    public HJ81() {
    }

    public boolean isAllCharExist(String pShortString, String pLongString) {
        Set<Character> set = new HashSet<>();
        for (char ch : pLongString.toCharArray()) {
            set.add(ch);
        }
        for (char ch : pShortString.toCharArray()) {
            if (!set.contains(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HJ81 solution = new HJ81();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String pShortString = in.nextLine();
            String pLongString = in.nextLine();
            boolean res = solution.isAllCharExist(pShortString, pLongString);
            System.out.println(res);
        }
    } 
}