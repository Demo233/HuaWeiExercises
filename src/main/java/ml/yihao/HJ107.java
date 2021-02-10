package ml.yihao;

import java.util.Scanner;

/**
 * @author zyh
 * @Description:
 * @date 2021/2/103:42
 * 题目描述
 * 计算一个数字的立方根，不使用库函数。
 * 保留一位小数。
 * <p>
 * <p>
 * 输入描述:
 * 待求解参数，为double类型（一个实数）
 * <p>
 * 输出描述:
 * 输入参数的立方根。保留一位小数。
 */
public class HJ107 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double res = getCubeRoot(sc.nextDouble());
            System.out.printf("%.1f", res);
        }

    }

    private static double getCubeRoot(double num) {
        //负数的情况
        if (num < 0)
            return -1 * getCubeRoot(-num);

        if (num == 0 || num == 1)
            return num;

        //分y大于1和y小于1两种情况，只是区间改变，算法一致
        double min = num > 1 ? 1 : 0;
        double max = num > 1 ? num : 1;

        while (max - min > 0.001) {
            double mid = (max + min) / 2;
            if (mid * mid * mid == num)
                return mid;
            else if (mid * mid * mid > num) {
                max = mid;
            } else {
                min = mid;
            }
        }
        return max;
    }
}
