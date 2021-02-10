package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 *
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 *
 * 本题含有多组数据。
 *
 * 输入描述:
 * 整数N，后续N个名字
 *
 * 输出描述:
 * 每个名称可能的最大漂亮程度
 */
public class HJ45 {

    private final int N = 26;

    public HJ45() {
    }

    public int count(String name) {
        int[] arr = new int[N];
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            arr[ch - 'a']++;
        }
        Arrays.sort(arr);
        int result = 0;
        for (int weight = N, i = N - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                result += weight * arr[i];
                weight--;
            }
        }
        return result;
    }

    public static void main(String[] args) 
    {
        HJ45 solution = new HJ45();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            for (int i = 0; i < n; i++) {
                String name = in.nextLine().toLowerCase();
                int result = solution.count(name);
                System.out.println(result);
            }
        }
    } 
}   