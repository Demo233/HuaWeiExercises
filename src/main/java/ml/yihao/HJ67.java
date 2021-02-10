package ml.yihao;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目描述
 * 有6条配置命令，它们执行的结果分别是：
 * 注意：he he不是命令。
 *
 * 为了简化输入，方便用户，以“最短唯一匹配原则”匹配：
 * 1、若只输入一字串，则只匹配一个关键字的命令行。例如输入：r，根据该规则，匹配命令reset，执行结果为：reset what；输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
 * 2、若只输入一字串，但本条命令有两个关键字，则匹配失败。例如输入：reb，可以找到命令reboot backpalne，但是该命令有两个关键词，所有匹配失败，执行结果为：unknown command
 * 3、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果仍不唯一，匹配失败。例如输入：r b，找到匹配命令reset board 和 reboot backplane，执行结果为：unkown command。
 *
 * 4、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果唯一，匹配成功。例如输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
 * 5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。例如输入：bo a，确定是命令board add，匹配成功。
 * 6、若匹配失败，打印“unknown command”
 */
public class HJ67 {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s1 = "reset";
    String s2 = "reset board";
    String s3 = "board add";
    String s4 = "board delete";
    String s5 = "reboot backplane";
    String s6 = "backplane abort";

    while(sc.hasNextLine()){
        String s = sc.nextLine();
        if(s.matches(s1)){
            System.out.println("reset what");
        }else if (s.matches(s2)) {
            System.out.println("board fault");
        }else if (s.matches(s3)) {
            System.out.println("where to add");
        }else if (s.matches(s4)) {
            System.out.println("no board at all");
        }else if (s.matches(s5)) {
            System.out.println("impossible");
        }else if (s.matches(s6)) {
            System.out.println("install first");
        }else{
            System.out.println("unknown command");
        }
    }

}
}