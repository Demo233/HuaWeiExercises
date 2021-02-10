package ml.yihao;

import java.util.*;

public class HJ26 {
    
    public String sort(String str){
        
        // 收集字符
        List<Character> letter = new ArrayList<Character>();
        for(Character chars: str.toCharArray()){
            if(Character.isLetter(chars)){
                letter.add(chars);
            }
        }
        
        // 排序
        letter.sort(new Comparator<Character>(){
            public int compare(Character c1, Character c2){
                return Character.toLowerCase(c1) - Character.toLowerCase(c2);
            }
        });
            
        // 遍历字符串
        StringBuffer sb = new StringBuffer();
        for(int i=0,j=0 ; i<str.length(); i++){
            if(Character.isLetter(str.charAt(i))){
                sb.append(letter.get(j++));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args){
        
        HJ26 solution = new HJ26();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            str = solution.sort(str);
            System.out.println(str);
        }
    }
}