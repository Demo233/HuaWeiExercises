package ml.yihao;

import java.util.Scanner;

/**
 * 题目描述
 * 问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。玩家需要根据9X9盘面上的已知数字，推算出所有剩余空格的数字，并且满足每一行、每一列、每一个粗线宫内的数字均含1-9，并且不重复。
 * 输入：
 * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
 * 输出：
 * 完整的9X9盘面数组
 *
 * 输入描述:
 * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
 *
 * 输出描述:
 * 完整的9X9盘面数组
 */
public class HJ44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 初始化数独
            int[][] sd = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sd[i][j] = scanner.nextInt();
                }
            }

            // 填充数独
            dfs(sd, 0, 0);

            // 打印数独
            for (int[] row : sd) {
                for (int i = 0; i < 9; i++) {
                    System.out.print(row[i]);
                    if (i != 8) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    private static boolean dfs(int[][] sd, int i, int j) {
        // (9,0)坐标
        if (i == 9) {
            return true;
        }
        if (sd[i][j] == 0) {
            for (int k = 1; k <= 9; k++) {
                sd[i][j] = k;
                if (check(sd, i, j) && dfs(sd, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1)) {
                    return true;
                }
            }
            sd[i][j] = 0;// 回溯
            return false;
        } else {
            return dfs(sd, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1);
        }
    }

    private static boolean check(int[][] sd, int i, int j) {
        // 同行
        for (int k = 0; k < 9; k++) {
            if (k != j && sd[i][k] == sd[i][j]) {
                return false;
            }
        }

        // 同列
        for (int k = 0; k < 9; k++) {
            if (k != i && sd[k][j] == sd[i][j]) {
                return false;
            }
        }

        // 同九宫
        int up = i / 3 * 3;
        int left = j / 3 * 3;
        for (int k = up; k < up + 3; k++) {
            for (int l = left; l < left + 3; l++) {
                if ((k != i || l != j) && sd[k][l] == sd[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}