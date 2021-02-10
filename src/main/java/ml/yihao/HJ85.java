package ml.yihao;

import java.util.Scanner;

/**
 * 题目描述
 * 给定一个仅包含小写字母的字符串，求它的最长回文子串的长度。
 * 所谓回文串，指左右对称的字符串。
 * 所谓子串，指一个字符串删掉其部分前缀和后缀（也可以不删）的字符串
 * （注意：记得加上while处理多个测试用例）
 *
 * 输入描述:
 * 输入一个仅包含小写字母的字符串
 *
 * 输出描述:
 * 返回最长回文子串的长度
 */
public class HJ85 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.reverse();
            int max = 0;
            for(int i = 0 ;i < str.length(); i++){
                for(int j = i + 1; j < str.length(); j++){
                    if(str.contains(sb.substring(i,j))){
                        if(j - i > max){
                            max = j - i;
                        }
                    }
                }
            }

            System.out.println(max);
        }
    }
}