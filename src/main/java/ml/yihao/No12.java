package ml.yihao;

import java.util.Scanner;

/**
 * @author zyh
 * @Description:
 * @date 2021/2/910:47 上午
 * 题目描述
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 *
 * 输入描述:
 * 输入一行，为一个只包含小写字母的字符串。
 *
 * 输出描述:
 * 输出该字符串反转后的字符串。
 */
public class No12 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer sb = new StringBuffer(str);
        System.out.println(sb.reverse());

    }
}
