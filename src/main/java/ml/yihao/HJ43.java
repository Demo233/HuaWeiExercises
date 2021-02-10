package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：
 *
 *
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 0, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,
 * };
 *
 *
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。
 *
 *
 * 本题含有多组数据。
 *
 * 输入描述:
 * 输入两个整数，分别表示二位数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 *
 * 输出描述:
 * 左上角到右下角的最短路径，格式如样例所示。
 */
public class HJ43
{
    private int n;
    private int m;
    private int[][] maze;
    private class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
        public String toString() {
            return "(" + i + "," + j + ")";
        }
    }

    public HJ43(int n, int m, int[][] maze) {
        this.n = n;
        this.m = m;
        this.maze = maze;
    }

    private boolean dfs(int[][] maze, int i, int j, Stack<Pair>paths) {
        if (maze[i][j] != 0) return false;
        paths.push(new Pair(i, j));
        // at the end point
        if (i == n - 1 && j == m - 1) return true;
        // go down
        if (i + 1 < n && dfs(maze, i+1, j, paths)) {
            return true;
        }
        // go right
        if (j + 1 < m && dfs(maze, i, j+1, paths)) {
            return true;
        }
        paths.pop();
        return false;
    }

    public void solve() {
        Stack<Pair> paths = new Stack<>();
        dfs(maze, 0, 0, paths);
        for (Pair point : paths) {
            System.out.println(point);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] maze = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maze[i][j] = in.nextInt();
                }
            }
            HJ43 solution = new HJ43(n, m, maze);
            solution.solve();
        }
    }
}
