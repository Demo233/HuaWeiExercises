package ml.yihao;

import java.util.Scanner;

/**
 * @author zyh
 * @Description:
 * @date 2021/2/910:47 上午
 * 题目描述
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 *
 * 输入描述:
 * 输入一个英文语句，每个单词用空格隔开。保证输入只包含空格和字母。
 *
 * 输出描述:
 * 得到逆序的句子
 */
public class No13 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        for(int i=arr.length-1; i>=0 ; i--){
            System.out.print(arr[i] + " " );
        }
    }
}
