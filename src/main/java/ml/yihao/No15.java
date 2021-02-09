package ml.yihao;

import java.util.Scanner;

/**
 * @author zyh
 * @Description:
 * @date 2021/2/910:49 上午
 * 题目描述
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 *
 * 输入描述:
 *  输入一个整数（int类型）
 *
 * 输出描述:
 *  这个数转换成2进制后，输出1的个数
 */
public class No15 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = Integer.toBinaryString(n);
        String[] strArr = str.split("");
        int cnt = 0;
        for(int i=0; i< strArr.length; i++){
            if(strArr[i].equals("1")){
                cnt ++;
            }
        }
        System.out.println(cnt);
    }
}
