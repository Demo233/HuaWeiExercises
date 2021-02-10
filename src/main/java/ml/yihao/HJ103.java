package ml.yihao;

import java.util.Scanner;

/**
 * @author zyh
 * @Description:
 * @date 2021/2/103:49 下午
 * 题目描述
 * Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
 *
 * 本题含有多组样例输入
 *
 *
 * 输入描述:
 * 输入多行，先输入数组的个数，再输入相应个数的整数
 *
 * 输出描述:
 * 输出结果
 */
public class HJ103 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] dp = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }

            //dp[i] 保留了从第一个到第i-1个庄子能走的最大步数
            for(int i = 0 ; i < n; i++){
                dp[i] = 1;
                for(int j = 0; j < i; j++){
                    if(a[j] < a[i]){
                        //最终dp[i]的值为其前面的最大的dp[j] + 1；
                        dp[i] = Math.max(dp[i],dp[j] + 1);
                    }
                }
            }

            int max = 1;
            for(int i = 0; i < n; i++){
                if(dp[i] > max){
                    max = dp[i];
                }
            }

            System.out.println(max);

        }

        sc.close();
    }
}
