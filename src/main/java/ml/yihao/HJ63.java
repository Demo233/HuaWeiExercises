package ml.yihao;

import java.util.*;
import java.io.*;

/**
 * 题目描述
 * 一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。
 *
 * 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
 *
 * 本题含有多组样例输入。
 *
 * 输入描述:
 * 输入一个string型基因序列，和int型子串的长度
 *
 * 输出描述:
 * 找出GC比例最高的子串,如果有多个输出第一个的子串
 */
public class HJ63 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String in;
        while((in = br.readLine())!=null){
            int w= Integer.parseInt(br.readLine());//输入窗口大小
            System.out.println(getString(in,w));
        }
    }
    public static String getString(String in,int w){
        int maxLen=0;
        String res="";
        for(int i=0;i<in.length()-w+1;i++){
            int tmp=countSubString(in.substring(i,i+w));
            if(tmp>maxLen){
                maxLen=tmp;
                res=in.substring(i,i+w);
            }
        }

        return res;
    }
    public static int countSubString(String in){
        int count=0;
        for(int i=0;i<in.length();i++){
            if(in.charAt(i)=='C'||in.charAt(i)=='G')
                count++;
        }
        return count;
    }
}  
