package ml.yihao;

import java.util.*;

class Pair implements Comparable<Pair>{
    private int value;
    private int times;
    public Pair(int value, int times) {
        this.value = value;
        this.times = times;
    }
    public int compareTo(Pair that) {
        if (this.times == that.times) {
            return this.value - that.value;
        }
        return that.times - this.times;
    }
    public char get() {
        return (char)value;
    }
}

/**
 * 题目描述
 * 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。
 * 本题含有多组样例输入
 *
 * 输入描述:
 * 一个只包含小写英文字母和数字的字符串。
 *
 * 输出描述:
 * 一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
 */
public class HJ102 {

    private final int N = 127;
    public HJ102() {
    }

    public String count(String str) {
        int[] arr = new int[N];
        for (char ch : str.toCharArray()) {
            if (ch >= N) continue;
            arr[ch]++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (arr[i] != 0) { 
                pq.offer(new Pair(i, arr[i]));
            }
        }
        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) {
            res.append(pq.poll().get());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        HJ102 solution = new HJ102();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String res = solution.count(str);
            System.out.println(res);
        }

    } 
}