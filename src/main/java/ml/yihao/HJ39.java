package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
 * 子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。利用子网掩码可以判断两台主机是否中同一子网中。若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。
 *
 * 示例：
 * I P 地址　 192.168.0.1
 * 子网掩码　 255.255.255.0
 *
 * 转化为二进制进行运算：
 *
 * I P 地址　11010000.10101000.00000000.00000001
 * 子网掩码　11111111.11111111.11111111.00000000
 *
 * AND运算
 * 11000000.10101000.00000000.00000000
 *
 * 转化为十进制后为：
 * 192.168.0.0
 *
 *
 * I P 地址　 192.168.0.254
 * 子网掩码　 255.255.255.0
 *
 *
 * 转化为二进制进行运算：
 *
 * I P 地址　11010000.10101000.00000000.11111110
 * 子网掩码　11111111.11111111.11111111.00000000
 *
 * AND运算
 * 11000000.10101000.00000000.00000000
 *
 * 转化为十进制后为：
 * 192.168.0.0
 *
 * 通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络。
 *
 * 输入一个子网掩码以及两个ip地址，判断这两个ip地址是否是一个子网络。
 * 若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2。
 *
 *
 * 输入描述:
 * 输入子网掩码、两个ip地址
 *
 * 输出描述:
 * 得到计算结果
 */
public class HJ39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String a=sc.next();
            String b=sc.next();
            String c=sc.next();
            String[] aa=a.split("\\.");
            String[] bb=b.split("\\.");
            String[] cc=c.split("\\.");
            int[] aaa=Arrays.stream(aa).mapToInt(Integer::parseInt).toArray();
            int[] bbb=Arrays.stream(bb).mapToInt(Integer::parseInt).toArray();
            int[] ccc=Arrays.stream(cc).mapToInt(Integer::parseInt).toArray();
            if(!isIp(bbb)||!isIp(ccc)||!isAd(aaa)){
                System.out.println(1);
                continue;
            }
            boolean flag=true;
            for(int i=0;i<4;i++){
               if((bbb[i]&aaa[i])!=(ccc[i]&aaa[i])){
                    System.out.println(2);
                    flag=false;
                    break;
                }
            }
            if(flag)
                System.out.println(0);
 
 
        }
        sc.close();
    }
 
    public static boolean isAd(int[] a){
        return a[0]>=0&&a[0]<=255&&
                a[1]>=0&&a[1]<=255&&
                a[2]>=0&&a[2]<=255&&
                a[3]>=0&&a[3]<=255&&
                a[0]>=a[1]&&
                a[1]>=a[2]&&
                a[2]>=a[3];
    }
 
    public static boolean isIp(int[] a){
        return a[0]>=0&&a[0]<=255&&
                a[1]>=0&&a[1]<=255&&
                a[2]>=0&&a[2]<=255&&
                a[3]>=0&&a[3]<=255;
    }
 
}