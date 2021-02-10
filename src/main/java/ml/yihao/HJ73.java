package ml.yihao;

import java.util.Scanner;

/**
 * 题目描述
 * 根据输入的日期，计算是这一年的第几天。。
 *
 * 测试用例有多组，注意循环输入
 *
 * 输入描述:
 * 输入多行，每行空格分割，分别是年，月，日
 *
 * 输出描述:
 * 成功:返回outDay输出计算后的第几天;
 */
public class HJ73 {

    private int leapMonth[] = {0, 31,29,31,30,31,30,31,31,30,31,30,31};
    private int normalMonth[] = {0, 31,28,31,30,31,30,31,31,30,31,30,31};
    private int result;

    public HJ73() {
    }

    public int iConverDateToDay(int year, int month, int day) {
        if (year <= 0 || month <= 0 || month > 12 || day <= 0) {
            return result = -1;
        }

        boolean isLeapYear = false;
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            isLeapYear = true;
        }
        if (isLeapYear && day > leapMonth[month]) {
            return result = -1;
        }
        if (!isLeapYear && day > normalMonth[month]) {
            return result = -1;
        }
        result = 0;
        for (int i = 1; i < month; i++) {
            if (isLeapYear) {
                result += leapMonth[i];
            }
            else {
                result += normalMonth[i];
            }
        }
        result += day;
        return 0;        
    }

    public int getOutDay() {
        return result;
    }

    public static void main(String[] args) {
        HJ73 solution = new HJ73();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int year = in.nextInt(), month = in.nextInt(), day = in.nextInt();
            solution.iConverDateToDay(year, month, day);
            int result = solution.getOutDay();
            System.out.println(result);
        }
    }
}