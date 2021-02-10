package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 输入两个用字符串表示的整数，求它们所表示的数之和。
 * 字符串的长度不超过10000。
 * 本题含有多组样例输入。
 * 输入描述:
 * 输入两个字符串。保证字符串只含有'0'~'9'字符
 *
 * 输出描述:
 * 输出求和后的结果
 */
public class HJ57 {

    public HJ57() {
    }

    // return num1 > num2 ?
    private int compare(String num1, String num2) {
        if (num1.length() > num2.length()) return 1;
        if (num1.length() < num2.length()) return -1;
        for (int i = 0, j = 0; i < num1.length() && j < num2.length(); i++, j++) {
            if (num1.charAt(i) > num2.charAt(j)) {
                return 1;
            }
            if (num1.charAt(i) < num2.charAt(j)) {
                return -1;
            }
        }
        return 0;
    }

    public String sub(String num1, String num2) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        // num1 > num2, so num1 - num2
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum -= num2.charAt(j--) - '0';
            }
            if (sum < 0) {
                stack.push(sum + 10);
                carry = -1;
            }
            else {
                stack.push(sum);
                carry = 0;
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }

    public String add(String num1, String num2) {
        if (num1.startsWith("-") && num2.startsWith("-")) {
            num1 = num1.substring(1);
            num2 = num2.substring(1);
            return "-" + add(num1, num2);
        }
        else if (num1.startsWith("-")) {
            num1 = num1.substring(1);
            int flag = compare(num1, num2);
            if      (flag ==  1) return "-" + sub(num1, num2);
            else if (flag == -1) return sub(num2, num1);
            else                 return "0";
        }
        else if (num2.startsWith("-")) {
            // num1 - num2
            return add(num2, num1);
        }
        else {
            StringBuilder res = new StringBuilder();
            Stack<Integer> stack = new Stack<>();
            // two positive sum
            int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
            while (i >= 0 || j >= 0 || carry != 0) {
                int sum = carry;
                if (i >= 0) {
                    sum += num1.charAt(i--) - '0';
                }
                if (j >= 0) {
                    sum += num2.charAt(j--) - '0';
                }
                stack.push(sum % 10);
                carry = sum / 10;
            }
            while (!stack.isEmpty()) {
                res.append(stack.pop());
            }
            return res.toString();
        }
    }

    public static void main(String[] args) {
        HJ57 solution = new HJ57();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String num1 = in.next();
            String num2 = in.next();
            String res = solution.add(num1, num2);
            System.out.println(res);
        }
    } 
}