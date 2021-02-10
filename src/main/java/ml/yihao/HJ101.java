package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序（一组测试用例可能会有多组数据）
 *
 * 本题有多组输入，请使用while(cin>>)处理
 *
 * 输入描述:
 * 第一行输入数组元素个数
 * 第二行输入待排序的数组，每个数用空格隔开
 * 第三行输入一个整数0或1。0代表升序排序，1代表降序排序
 *
 * 输出描述:
 * 输出排好序的数字
 */
public class HJ101 {

    public HJ101() {
    }

    public void sortIntegerArray(Integer[] pIntegerArray, int iSortFlag) {
        // 按升序
        if (iSortFlag == 0) {
            Arrays.sort(pIntegerArray, new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
        }
        // 按降序
        else {
            Arrays.sort(pIntegerArray, new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }
    }

    public void output(Integer[] array) {
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HJ101 solution = new HJ101();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            Integer[] array = new Integer[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            int flag = in.nextInt();
            solution.sortIntegerArray(array, flag);
            solution.output(array);
        }

    } 
}