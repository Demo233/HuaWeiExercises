package ml.yihao;

import java.util.Scanner;
import java.util.LinkedHashSet;
import java.util.ArrayList;

/**
 * 题目描述
 * 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。现在，修改过的那个单词属于字母表的下面，如下所示：
 *
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 *
 * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
 *
 * 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。因此，使用这个密匙，Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。
 *
 * 请实现下述接口，通过指定的密匙和明文得到密文。
 *
 *
 * 本题有多组输入数据。
 *
 * 输入描述:
 * 先输入key和要加密的字符串
 *
 * 输出描述:
 * 返回加密后的字符串
 */
public class HJ36 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine().toUpperCase();
            String s2 = sc.nextLine();
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            LinkedHashSet<Character> set = new LinkedHashSet();
            for (int i = 0; i < chars1.length; i++) {
                set.add(chars1[i]);
            }
            int k = 0;
            while (set.size() < 26) {
                char a = (char) ('A' + k);
                set.add(a);
                k++;
            }
            ArrayList<Character> list = new ArrayList<>(set);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < chars2.length; i++) {
                if (chars2[i] == ' ') {
                    sb.append(chars2[i]);
                } else if (chars2[i] < 'a') {
                    int n = (int) (chars2[i] - 'A');
                    char c = list.get(n);
                    sb.append(c);
                } else {
                    int n = (int) (chars2[i] - 'a');
                    char c = (char)(list.get(n)+'a'-'A');
                    sb.append(c);
                }
 
            }
 
            System.out.println(sb.toString());
        }
    }
}