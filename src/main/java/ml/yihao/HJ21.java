package ml.yihao;

import java.util.Arrays;
import java.util.Scanner;

public class HJ21{
    public static void main(String[] args){
        
        String[] arr = new String[]{"A", "B", "C", "D", "E", "F", "G",
                "H", "I", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y", "Z"};
        Obj[] map = new Obj[]{
                new Obj("1", "1"),//abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,
                new Obj("a", "2"), new Obj("b", "2"), new Obj("c", "2"),
                new Obj("d", "3"), new Obj("e", "3"), new Obj("f", "3"),
                new Obj("g", "4"), new Obj("h", "4"), new Obj("i", "4"),
                new Obj("j", "5"), new Obj("k", "5"), new Obj("l", "5"),
                new Obj("m", "6"), new Obj("n", "6"), new Obj("o", "6"),
                new Obj("p", "7"), new Obj("q", "7"), new Obj("r", "7"), new Obj("s", "7"),
                new Obj("t", "8"), new Obj("u", "8"), new Obj("v", "8"),
                new Obj("w", "9"), new Obj("x", "9"), new Obj("y", "9"), new Obj("z", "9"),
                new Obj("0", "0"),
        };
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<str.length(); i++){
                String oc = str.substring(i,i+1);
                int index = Arrays.binarySearch(arr, oc);
                if(index >= 0){
                    // 找到
                    if(index == arr.length-1){
                        sb.append(arr[0].toLowerCase());
                    }else{
                        sb.append(arr[index + 1].toLowerCase());
                    }
                }else{
                    try{
                        Integer.parseInt(oc);
                        sb.append(oc);
                    }catch(Exception e){
                        out:
                        for(int i1=0 ; i1<map.length; i1++){
                            if(oc.equals(map[i1].rce)){
                                sb.append(map[i1].rtn);
                                break out;
                            }
                        }
                        
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
    
}

class Obj {
    String rce;
    String rtn;

    public Obj(String rce, String rtn) {
        this.rce = rce;
        this.rtn = rtn;
    }
}
