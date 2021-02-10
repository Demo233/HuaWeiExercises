package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 输入一个字符串和一个整数k，截取字符串的前k个字符并输出
 * 本题输入含有多组数据
 * 输入描述:
 * 第一行输入待截取的字符串
 *
 *
 * 第二行输入一个正整数k，代表截取的长度
 *
 * 输出描述:
 * 截取后的字符串
 */
public class HJ46 {
    
    public static void main(String[] args) throws Exception{
        
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            String[] str = new String[s.length()];
            for(int i=0; i<str.length; i++){
                str[i] = s.charAt(i) + "";
            }
            int K = sc.nextInt();
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<str.length; i++){
                int len = str[i].getBytes("GBK").length;
                if(K >= len){
                    K -= len;
                    sb.append(str[i]);
                }else{
                    break;
                }
            }
            System.out.println(sb.toString());
        }
        
    }
}