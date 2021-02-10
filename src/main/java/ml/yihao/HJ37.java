package ml.yihao;

import java.util.Scanner;

/**
 * 题目描述
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 *
 * 本题有多组数据。
 *
 * 输入描述:
 * 输入int型表示month
 *
 * 输出描述:
 * 输出兔子总数int型
 */
public class HJ37 {
 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(getTotalCount(n));
        }
    }
 
    public static int getTotalCount(int monthCount)
    {
        if(monthCount < 3){
            return 1;
        }
        return getTotalCount(monthCount - 2)  + getTotalCount(monthCount - 1) ;
    }
}