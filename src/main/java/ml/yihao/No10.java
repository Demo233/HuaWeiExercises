package ml.yihao;

import java.util.BitSet;
import java.util.Scanner;

/**
 * @author zyh
 * @Description:
 * @date 2021/2/910:46 上午
 * 题目描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
 * 输入描述:
 * 输入一行没有空格的字符串。
 *
 * 输出描述:
 * 输出范围在(0~127)字符的个数。
 */
public class No10 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        BitSet bitSet = new BitSet(128);
        char[] chars = str.toCharArray();
        for(int i=0; i<chars.length; i++){
            if(!bitSet.get(chars[i])){
                bitSet.set(chars[i]);
            }
        }
        System.out.println(bitSet.cardinality());


    }

}
