package ml.yihao;

import java.util.Scanner;

/**
 * @author zyh
 * @Description:
 * @date 2021/2/910:45 上午
 * 题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是0。
 * 输入描述:
 * 输入一个int型整数
 *
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 */
public class No9 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        char[] strArr = (num+"").toCharArray();
        String t = "";
        for(int i=strArr.length-1; i>=0; i--){
            if(!t.contains(strArr[i]+"")){
                t += strArr[i];
            }
        }
        System.out.println(Integer.valueOf(t));
    }
}
