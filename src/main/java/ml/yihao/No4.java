package ml.yihao;

import java.util.Scanner;

/**
 * @author zyh
 * @Description:
 * @date 2021/2/910:42 上午
 * 题目描述
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * 输入描述:
 * 连续输入字符串(输入多次,每个字符串长度小于100)
 *
 * 输出描述:
 * 输出到长度为8的新字符串数组
 */
public class No4 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            // 确定是否存在下一个
            String str = sc.nextLine();
            // 判断字符串是否需要补0
            int addZero = 8 - str.length() % 8;
            StringBuffer sb = new StringBuffer();
            sb.append(str);
            while(addZero > 0 && addZero < 8){
                sb.append("0");
                addZero --;
            }
            // 每8个截取
            str = sb.toString();
            while(str.length() > 0){
                System.out.println(str.substring(0,8));
                str = str.substring(8);
            }

        }

    }
}
