package ml.yihao;

import java.util.*;

/**
 题目描述
 输入int型数组，询问该数组能否分成两组，使得两组中各元素加起来的和相等，并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），能满足以上条件，输出true；不满足时输出false。
 本题含有多组样例输入。
 输入描述:
 第一行是数据个数，第二行是输入的数据

 输出描述:
 返回true或者false */
public class HJ93 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            LinkedList<Integer> list = new LinkedList<>();
            int n = in.nextInt();
            int sum5 = 0;
            int sum3 = 0;
            int sum = 0;
            for (int i = 0; i < n; i++){
                int cur = in.nextInt();
                if (cur % 5 == 0){
                    sum5 += cur;
                }else if (cur % 3 == 0){
                    sum3 += cur;
                }else{
                    list.add(cur);
                }
                sum += cur;
            }
            int target = sum/2 - sum3;
            if (sum % 2 != 0) System.out.println("false");
            else System.out.println(helper(list, target));
        }
    }
    private static boolean helper(LinkedList<Integer> list, int target){
        return helper(0, list, target);
    }
    private static boolean helper(int l, LinkedList<Integer> list, int target){
        if (l == list.size()) return target == 0;
        return helper(l + 1, list, target - list.get(l)) || helper(l + 1, list, target);
    }
}