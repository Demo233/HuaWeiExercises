package ml.yihao;

import java.util.*;

public class HJ23 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            char[] arr = str.toCharArray();
            // 初始化每个字符的个数
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for(int i=0 ; i<arr.length ; i++){
                map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
            }
            // 查询map中最小值
            int min = Integer.MAX_VALUE;
            for(int times: map.values()){
                min = Math.min(min, times);
            }
            
            // 删除最小值
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<arr.length; i++){
                if(map.get(arr[i]) != min){
                    sb.append(arr[i]);
                }
            }
            System.out.println(sb.toString());
        }
    }
}