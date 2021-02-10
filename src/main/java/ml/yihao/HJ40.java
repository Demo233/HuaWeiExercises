package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 *
 * 本题包含多组输入。
 *
 *
 * 输入描述:
 * 输入一行字符串，可以有空格
 *
 * 输出描述:
 * 统计其中英文字符，空格字符，数字字符，其他字符的个数
 */
public class HJ40 {
     public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         while(sc.hasNext()){
             int isLetter=0,isDigit=0,isWhitespace=0,isQt=0;
             char[] str = sc.nextLine().toCharArray();
             for(int i=0;i<str.length;i++){
                 char a = str[i];
                 if(Character.isLetter(a))
                     isLetter++;
                 else if(Character.isDigit(a))
                     isDigit++;
                 else if(Character.isWhitespace(a))
                     isWhitespace++;
                 else isQt++;
             }
             System.out.println(isLetter);
             System.out.println(isWhitespace);
             System.out.println(isDigit);
             System.out.println(isQt);
         }
     }
}