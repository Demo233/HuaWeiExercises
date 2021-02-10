package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 矩阵乘法的运算量与矩阵乘法的顺序强相关。
 * 例如：
 *
 * A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
 *
 * 计算A*B*C有两种顺序：（（AB）C）或者（A（BC）），前者需要计算15000次乘法，后者只需要3500次。
 *
 * 编写程序计算不同的计算顺序需要进行的乘法次数。
 *
 * 本题含有多组样例输入！
 *
 *
 *
 * 输入描述:
 * 输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则
 * 计算的法则为一个字符串，仅由左右括号和大写字母（'A'~'Z'）组成，保证括号是匹配的且输入合法！
 *
 * 输出描述:
 * 输出需要进行的乘法次数
 */
public class HJ70 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            List<matrix> list = new LinkedList<>();
            for (int i = 0; i < n; i++){
                int mcur = in.nextInt();
                int ncur = in.nextInt();
                list.add(new matrix(mcur, ncur));
            }
            Deque<matrix> stack = new LinkedList<>();
            int res = 0;
            String s = in.next();
            for (int i = s.length() - 1; i >= 0; i--){
                if (s.charAt(i) == ')'){
                    stack.offerLast(new matrix(-1,-1));
                }else if (s.charAt(i) == '('){
                    res += helper(stack);
                }else{
                    int cur = (int)(s.charAt(i) - 'A');
                    stack.offerLast(list.get(cur));
                }
            }
            System.out.println(res);
        }
    }

    private static int helper(Deque<matrix> stack){
        matrix pre = stack.pollLast();
        int res = 0;
        while(true){
            matrix cur = stack.pollLast();
            if (cur.helper()) break;
            res += pre.mul(cur);
            pre = new matrix(pre.m, cur.n);
        }
        stack.offerLast(pre);
        return res;
    }

}
class matrix{
    int m;
    int n;
    matrix(int m, int n){
        this.m = m;
        this.n = n;
    }
    int mul(matrix m2){
        return (this.m * this.n * m2.n);
    }
    boolean helper(){
        return this.m == -1;
    }
}