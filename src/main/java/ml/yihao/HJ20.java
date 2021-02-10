package ml.yihao;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author zyh
 * @Description:
 * @date 2021/2/94:11 下午
 */
public class HJ20 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String pwd = scanner.nextLine();
            match(pwd);
        }
    }

    public static void match(String pwd){
        int index = -1;
        // 长度超过8位
        index = check1(pwd);
        if(index == -1){
            System.out.println("NG");
            return;
        }

        index = check2(pwd);
        if(index == -1){
            System.out.println("NG");
            return;
        }

        index = check3(pwd);
        if(index == -1){
            System.out.println("NG");
            return;
        }

        System.out.println("OK");

    }

    public static int check1(String pwd){
        if(pwd.length()<=8){
            return -1;
        }
        return 1;
    }

    public static int check2(String pwd){
        int count = 0;
        Pattern p1 = Pattern.compile("[A-Z]");
        if(p1.matcher(pwd).find()){
            count ++;
        }

        Pattern p2 = Pattern.compile("[a-z]");
        if(p2.matcher(pwd).find()){
            count ++;
        }

        Pattern p3 = Pattern.compile("[0-9]");
        if(p3.matcher(pwd).find()){
            count ++;
        }

        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
        if(p4.matcher(pwd).find()){
            count ++;
        }
        if(count >= 3){
            return 1;
        }else {
            return -1;
        }
    }

    public static int check3(String pwd){
        for(int i =0 ; i < pwd.length() - 3; i++){
            String subStr1 = pwd.substring(i, i+3);
            if(pwd.substring(i+1).contains(subStr1)){
                return -1;
            }
        }
        return 1;

    }
}
