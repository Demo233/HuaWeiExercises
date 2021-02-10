package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 *
 * 本题含有多组样例输入。
 *
 * 输入描述:
 * 输入一个字符串
 *
 * 输出描述:
 * 返回有效密码串的最大长度
 */
public class HJ32 {

    //主方法
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            //两种回文字符，让最大的上
            int max = Math.max(maxPalindrome(str), maxPalindrome2(str));
            System.out.println(max);
        }
    }


    public static int maxPalindrome(String str) {
        int max = 1;//先定义最大长度为1
        for (int i = 1; i < str.length() - 1; i++) { //ABA形状最少得三个吧，所以从坐标一开始遍历，到长度-2为止
            //判断能找点i到数组边界的半径，也就是循环能走多少次，一个数组，左边的数据，坐标为i的到坐标为0的长度就是i，末尾的就是长度减i-1，其实拿笔画一下就理解了
            int count = Math.min(i, str.length() - i - 1);
            int maxCount = 1; //本次找到得最长长度
            //以i为中心，如果两侧字符一样，再找下一个，断了就break，这样找到以该点为中心的最长的回文字符
            for (int j = 1; j <= count; j++) {
                if (str.charAt(i - j) == str.charAt(i + j)) {
                    maxCount += 2;
                } else {
                    break;
                }
            }

            max = Math.max(max, maxCount);
        }
        return max;
    }

    //判断ABBA型最大长度的方法
    public static int maxPalindrome2(String str) {
        int max = 1;
        for (int i = 1; i < str.length() - 1; i++) {
            int count = Math.min(i, str.length() - i - 2);
            int maxCount = 1;
            //原理和上面类似，不过是先找到一对一样的字符也就是ABBA中的BB
            if (str.charAt(i) == str.charAt(i + 1)) {
                maxCount = 2;
                for (int j = 1; j <= count; j++) {
                    if (str.charAt(i - j) == str.charAt(i + j + 1)) {
                        maxCount += 2;
                    } else {
                        break;
                    }
                }
            }
            //保留最长的
            max = Math.max(max, maxCount);
        }
        return max;
    }
}