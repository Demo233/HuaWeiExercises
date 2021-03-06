package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
 * 每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 *
 *
 * 注：
 *
 * 称重重量包括0
 *
 *
 * 输入描述:
 * 输入包含多组测试数据。
 *
 * 对于每组测试数据：
 *
 * 第一行：n --- 砝码数(范围[1,10])
 *
 * 第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])
 *
 * 第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
 * 输出描述:
 * 利用给定的砝码可以称出的不同的重量数
 */
public class HJ41 {
    public static int fama(int n, int[] weight, int[] nums){
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i <= nums[0]; i++){
            set.add(weight[0] * i);
        }
        for(int i = 1; i < n; i++){
            List<Integer> list = new ArrayList<Integer>(set);
            for(int j = 0; j <= nums[i]; j++){
                for(int k = 0; k < list.size(); k++){
                 set.add(list.get(k) + j * weight[i]);
                }
            }
        }
        return set.size();
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] weight = new int[n];
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                weight[i] = in.nextInt();
            }
            for(int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }
            System.out.println(fama(n, weight, nums));
        }
        in.close();
    }
}