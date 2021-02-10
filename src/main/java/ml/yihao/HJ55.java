package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 输出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）的个数（一组测试用例里可能有多组数据，请注意处理）
 *
 * 输入描述:
 * 一个正整数N。(N不大于30000)
 *
 * 输出描述:
 * 不大于N的与7有关的数字个数，例如输入20，与7有关的数字包括7,14,17.
 */
public class HJ55 {

    public HJ55() {
    }

    private boolean conatins7(int n) {
        while (n != 0) {
            if (n % 10 == 7) return true;
            n /= 10;
        }
        return false;
    }

    public int count(int n) {
        int count = 0;
        for (int i = 7; i <= n; i++) {
            if (i % 7 == 0 || conatins7(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        HJ55 solution = new HJ55();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = Integer.parseInt(in.next());
            int res = solution.count(n);
            System.out.println(res);
        }
    } 
}