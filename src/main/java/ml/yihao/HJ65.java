package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 * 注：子串的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。请和“子序列”的概念分开！
 *
 * 本题含有多组输入数据！
 * 输入描述:
 * 输入两个字符串
 *
 * 输出描述:
 * 返回重复出现的字符
 */
public class HJ65 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String stra = sc.next();
            String strb = sc.next();
            String longStr = (stra.length() > strb.length()) ? stra:strb;
            String shortStr = (stra.length() < strb.length()) ? stra:strb;
            List list = new ArrayList();
            Map map = new HashMap();
            List list2 = new ArrayList();
            List list3 = new ArrayList();
            for(int i=0;i<shortStr.length();i++){
                String s = "";
                s = s + shortStr.charAt(i);
                for(int j = i+1;j<shortStr.length();j++){
                    s = s + shortStr.charAt(j);
//                     s = shortStr.substring(i,j+1);
                  if(longStr.contains(s)){
                      list.add(s);
                      list3.add(s.length());
                }
              }
            }
//             for(int i = 0;i<list.size();i++){
//                 list.get(i);
//                 list2.add(String.valueOf(list.get(i)).length());
//             }
            Collections.sort(list3);
            int numbera = (int)list3.get(list3.size()-1);
            for(int j = 0;j<list.size();j++){
                if(String.valueOf(list.get(j)).length() == numbera){
                    System.out.println(list.get(j));
                    break;
                }
            }
        }
    }
}