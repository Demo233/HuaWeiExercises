package ml.yihao;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * 题目描述
 * 信号测量的结果包括测量编号和测量值。存在信号测量结果丢弃及测量结果重复的情况。
 *
 *
 * 1.测量编号不连续的情况，认为是测量结果丢弃。对应测量结果丢弃的情况，需要进行插值操作以更准确的评估信号。
 *
 * 采用简化的一阶插值方法,由丢失的测量结果两头的测量值算出两者中间的丢失值。
 *
 * 假设第M个测量结果的测量值为A，第N个测量结果的测量值为B。则需要进行(N-M-1)个测量结果的插值处理。进行一阶线性插值估计的第N+i个测量结果的测量值为A+( (B-A)/(N-M) )*i  (注：N的编号比M大。)
 *
 * 例如：只有测量编号为4的测量结果和测量编号为7的测量结果，测量值分别为4和10
 *
 * 则需要补充测量编号为5和6的测量结果。
 *
 * 其中测量编号为5的测量值=4 + ((10-4)/(7-4))*1 = 6
 *
 * 其中测量编号为6的测量值=4 + ((10-4)/(7-4))*2 = 8
 *
 *
 * 2.测量编号相同，则认为测量结果重复，需要对丢弃后来出现的测量结果。
 *
 *
 * 请根据以上规则进行测量结果的整理。
 *
 *
 * 输入描述:
 * 输入说明
 * 1 输入两个整数m, n
 * 2 输入m个数据组
 *
 * 输出描述:
 * 输出整理后的结果
 */
public class HJ47 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            //二维数组存储键值对
            int[][] data=new int[n][2];
            for(int i=0;i<n;i++){
                data[i][0]=sc.nextInt();
                data[i][1]=sc.nextInt();
            }
            ArrayList<String> list=new ArrayList<String>();
            //若出现重复值,利用这两个变量存储前一个值,丢弃后出现的重复值(如题目要求)
            int KEY=data[0][0];
            int VALUE=data[0][1];
            list.add(KEY+" "+VALUE);
            for(int i=1;i<=n-1;i++){
                int diff=data[i][0]-KEY-1;
                if(diff>0){
                    for(int j=1;j<=diff;j++){
                        int key=KEY+j;
                        int value=VALUE+(data[i][1]-VALUE)/(data[i][0]-KEY)*j;
                        list.add(key+" "+value);
                    }
                    list.add(data[i][0]+" "+data[i][1]);
                    KEY=data[i][0];
                    VALUE=data[i][1];
                //两个键相等则直接跳过,此时KEY,VVALUE保存的还是上一个值
                }else if(diff==-1)
                    continue;
                else{
                    list.add(data[i][0]+" "+data[i][1]);
                    KEY=data[i][0];
                    VALUE=data[i][1];
                }
            }
            for(String s:list)
                System.out.println(s);
        }
    }
}