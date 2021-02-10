package ml.yihao;

import java.util.Scanner;
import java.util.LinkedHashMap;


/**
 * 题目描述
 * 请实现一个计票统计系统。你会收到很多投票，其中有合法的也有不合法的，请统计每个候选人得票的数量以及不合法的票数。
 * 本题有多组样例输入。
 * 输入描述:
 * 输入候选人的人数n，第二行输入n个候选人的名字（均为大写字母的字符串），第三行输入投票人的人数，第四行输入投票。
 *
 * 输出描述:
 * 按照输入的顺序，每行输出候选人的名字和得票数量，最后一行输出不合法的票数。
 */
public class HJ94 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //候选人
            int n = sc.nextInt();
            //把\n读了
            sc.nextLine();
            LinkedHashMap<String,Integer> hm = new LinkedHashMap<String,Integer>();
            for(int i = 0; i < n; i++){
                String name = sc.next();
                hm.put(name,0);
            }
            //sc.nextLine();
            //投票
            n = sc.nextInt();
            //把\n读了
            sc.nextLine();
            int invalid = 0;
            for(int i = 0;i < n; i++){
                String vote = sc.next();
                if(hm.containsKey(vote)){
                    hm.put(vote,hm.get(vote) + 1);
                }else{
                    invalid++;
                }
            }

            for(String key : hm.keySet()){
                System.out.println(key + " : " + hm.get(key));
            }
            System.out.println("Invalid : " + invalid);
        }
    }
}