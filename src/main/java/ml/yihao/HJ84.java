package ml.yihao;


import java.util.Scanner;

/**
 * 题目描述
 * 找出给定字符串中大写字符(即'A'-'Z')的个数。
 *
 * 输入描述:
 * 本题含有多组样例输入
 * 对于每组样例，输入一行，代表待统计的字符串
 *
 * 输出描述:
 * 对于每组样例，输出一个整数，代表字符串中大写字母的个数
 */
public class HJ84 {
    public static void main(String[] arg){
        Scanner s=new Scanner(System.in);
        while(s.hasNextLine()){
            String input1=s.nextLine();
            String input=input1.replaceAll("([A-Z]+)","");
            System.out.println(input1.length()-input.length());
        }
    }
}