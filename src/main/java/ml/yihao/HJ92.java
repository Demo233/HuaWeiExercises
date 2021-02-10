package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 输入一个字符串，返回其最长的数字子串，以及其长度。若有多个最长的数字子串，则将它们全部输出（按原字符串的相对位置）
 * 本题含有多组样例输入。
 *
 * 输入描述:
 * 输入一个字符串。
 *
 * 输出描述:
 * 输出字符串中最长的数字字符串和它的长度，中间用逗号间隔。如果有相同长度的串，则要一块儿输出（中间不要输出空格）。
 */
public class HJ92 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            s += "e";
            LinkedList<String> list = new LinkedList<>();
            int curLen = 0;
            int max = 0;
            StringBuilder sb = new StringBuilder();
            for (int p1 = 0; p1 < s.length(); p1++){
                char cc = s.charAt(p1); 
                if (isNumber(cc)){
                    curLen++;
                    sb.append(s.charAt(p1));

                }else if (!isNumber(s.charAt(p1)) && curLen != 0){
                    if (curLen == max){
                        list.add(sb.toString());
                    }else if (curLen > max){
                        list.clear();
                        list.add(sb.toString());
                        max = curLen;
                    }
                    curLen = 0;
                    sb = new StringBuilder();
                }

            }
            String output = "";
            for (int i = 0; i < list.size(); i++){
                output += list.get(i);
            }
            output += ",";
            output += max;
            System.out.println(output);
        }
    }
    private static boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }
}