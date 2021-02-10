package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 题目标题：
 *
 * 将两个整型数组按照升序合并，并且过滤掉重复数组元素。
 * 输出时相邻两数之间没有空格。
 * 请注意本题有多组样例。
 *
 *
 *
 * 输入描述:
 * 输入说明，按下列顺序输入：
 * 1 输入第一个数组的个数
 * 2 输入第一个数组的数值
 * 3 输入第二个数组的个数
 * 4 输入第二个数组的数值
 *
 * 输出描述:
 * 输出合并之后的数组
 */
public class HJ80 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            Set<Integer> set = new HashSet<>();
            int n1 = in.nextInt();
            for (int i = 0; i < n1; i++){
                set.add(in.nextInt());
            }
            int n2 = in.nextInt();
            for (int i = 0; i < n2; i++){
                set.add(in.nextInt());
            }
            int n3 = set.size();
            int[] arr = new int[n3];
            int k = 0;
            for (int i : set){
                arr[k] = i;
                k++;
            }
            Arrays.sort(arr);
            String res = "";
            for (int i = 0; i < n3; i++){
                res += arr[i];
            }
            System.out.println(res);
        }
    }
}