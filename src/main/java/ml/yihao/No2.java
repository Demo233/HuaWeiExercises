package ml.yihao;

import java.util.Scanner;

/**
 * @author zyh
 * @Description:
 * @date 2021/2/910:40 上午
 * 题目描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写。
 *
 * 输入描述:
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字母。
 *
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 */
public class No2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String c = sc.next();
        int num = 0 ;
        for (int i = 0; i <str.length() ; i++) {
            if(c.equalsIgnoreCase(str.substring(i, i+1))){
                num ++;
            }
        }
        System.out.println(num);
    }
}
