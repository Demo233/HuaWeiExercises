package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。这个矩阵的每个元素是由下面的公式决定的
 *
 * 矩阵的大小不超过100*100
 * 输入描述:
 * 输入包含多组数据，每组数据包含：
 *
 * 第一行包含一个正整数x，代表第一个矩阵的行数
 *
 * 第二行包含一个正整数y，代表第一个矩阵的列数和第二个矩阵的行数
 *
 * 第三行包含一个正整数z，代表第二个矩阵的列数
 *
 * 之后x行，每行y个整数，代表第一个矩阵的值
 *
 * 之后y行，每行z个整数，代表第二个矩阵的值
 *
 *
 *
 * 输出描述:
 * 对于每组输入数据，输出x行，每行z个整数，代表两个矩阵相乘的结果
 */
public class HJ69 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int m = in.nextInt();
            int n = in.nextInt();
            int k = in.nextInt();
            int[][] m1 = new int[m][n];
            int[][] m2 = new int[n][k];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    m1[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < n; i++){
                for (int j = 0; j < k; j++){
                    m2[i][j] = in.nextInt();
                }
            }
            int[][] res = mult(m1, m2, m, n, k);
            //System.out.println(res.length);
            //System.out.println(res[0].length);
            for (int i = 0; i < m; i++){
                String s = "";
                for (int j = 0; j < k; j++){
                    //System.out.println(j);
                    s += res[i][j];
                    s += " ";
                }
                System.out.println(s);
            }
        }
    }

    private static int[][] mult(int[][] m1, int[][] m2, int m, int n, int k){
        int[][] res = new int[m][k];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < k; j++){
                res[i][j] = helper(m1, m2, i, j, n);
            }
        }
        return res;
    }

    private static int helper(int[][] m1, int[][] m2, int i, int j, int n){
        int res = 0;
        for (int p = 0; p < n; p++){
            res += m1[i][p] * m2[p][j];
        }
        return res;
    }
}