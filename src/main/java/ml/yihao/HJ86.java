package ml.yihao;

import java.util.Scanner;

/**
 * 题目描述
 * 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 *
 * 本题含有多组样例输入。
 *
 * 输入描述:
 * 输入一个byte数字
 *
 * 输出描述:
 * 输出转成二进制之后连续1的个数
 */
public class HJ86 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//         while (in.hasNextByte()) {
//             byte num = in.nextByte();
        while(in.hasNextInt()){
            int num = in.nextInt();
            int max = 0;
            int count = 0;
            while(num != 0){
                if((num&1) == 1){
                    count++;
                    max = Math.max(max,count);
                }
                else{
                    count = 0;
                }
                num >>>= 1;
            }
            System.out.println(max);
        }
    }
}