package ml.yihao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zyh
 * @Description:
 * @date 2021/2/910:48 上午
 * 题目描述
 * 给定n个字符串，请对n个字符串按照字典序排列。
 * 输入描述:
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述:
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 */
public class No14 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int next = sc.nextInt();
        String[] arr = new String[next];
        for(int i=0; i < next; i ++){
            arr[i] = sc.next();
        }
        Arrays.sort(arr);
        for(int i=0; i < arr.length; i ++){
            System.out.println(arr[i]);
        }
    }
}
