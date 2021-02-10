package ml.yihao;

import java.util.Scanner;

/**
 * 题目描述
 * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
 *
 * 一、密码长度:
 *
 * 5 分: 小于等于4 个字符
 *
 * 10 分: 5 到7 字符
 *
 * 25 分: 大于等于8 个字符
 *
 * 二、字母:
 *
 * 0 分: 没有字母
 *
 * 10 分: 全都是小（大）写字母
 *
 * 20 分: 大小写混合字母
 *
 * 三、数字:
 *
 * 0 分: 没有数字
 *
 * 10 分: 1 个数字
 *
 * 20 分: 大于1 个数字
 *
 * 四、符号:
 *
 * 0 分: 没有符号
 *
 * 10 分: 1 个符号
 *
 * 25 分: 大于1 个符号
 *
 * 五、奖励:
 *
 * 2 分: 字母和数字
 *
 * 3 分: 字母、数字和符号
 *
 * 5 分: 大小写字母、数字和符号
 *
 * 最后的评分标准:
 *
 * >= 90: 非常安全
 *
 * >= 80: 安全（Secure）
 *
 * >= 70: 非常强
 *
 * >= 60: 强（Strong）
 *
 * >= 50: 一般（Average）
 *
 * >= 25: 弱（Weak）
 *
 * >= 0:  非常弱
 *
 *
 * 对应输出为：
 *
 * VERY_SECURE
 *
 * SECURE,
 *
 * VERY_STRONG,
 *
 * STRONG,
 *
 * AVERAGE,
 *
 * WEAK,
 *
 * VERY_WEAK,
 *
 *
 * 请根据输入的密码字符串，进行安全评定。
 *
 * 注：
 *
 * 字母：a-z, A-Z
 *
 * 数字：-9
 *
 * 符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
 *
 * !"#$%&'()*+,-./     (ASCII码：x21~0x2F)
 *
 * :;<=>?@             (ASCII<=><=><=><=><=>码：x3A~0x40)
 *
 * [\]^_`              (ASCII码：x5B~0x60)
 *
 * {|}~                (ASCII码：x7B~0x7E)
 *
 *
 *
 *
 * 输入描述:
 * 本题含有多组输入样例。
 * 每组样例输入一个string的密码
 *
 * 输出描述:
 * 每组样例输出密码等级
 */
public class HJ87
{
    public String GetPwdSecurityLevel(String pPasswordStr)
    {
        int score = 0;

        boolean number = false;
        boolean upper = false;
        boolean lower = false;
        boolean symbol = false;
        boolean numberOnce = true;
        boolean symbolOnce = true;

        if (pPasswordStr.length() <= 4) {
            score += 5;
        }

        else if (pPasswordStr.length() <= 7) {
            score += 10;
        }
        else {
            score += 25;
        }

        for (char ch : pPasswordStr.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                if (number && numberOnce) {
                    score += 20;
                    numberOnce = false;
                }
                number = true;
            }
            else if (ch >= 'a' && ch <= 'z') {
                lower = true;
            }
            else if (ch >= 'A' && ch <= 'Z') {
                upper = true;
            }
            else if (
                ch >= 0x21 && ch <= 0x2F || 
                ch >= 0x3A && ch <= 0x40 ||
                ch >= 0x5B && ch <= 0x60 ||
                ch >= 0x7B && ch <= 0x7E) 
            {
                if (symbol && symbolOnce) {
                    score += 25;
                    symbolOnce = false;
                }
                symbol = true;
            }

        }

        if (number && numberOnce) {
            score += 10;
        }
        if (symbol && symbolOnce) {
            score += 10;
        }
        if (lower && upper) {
            score += 20;
        }
        else if (lower || upper) {
            score += 10;
        }
        if (lower && upper && number && symbol) {
            score += 5;
        }
        else if ((lower || upper) && number && symbol) {
            score += 3;
        }
        else if ((lower || upper) && number) {
            score += 2;
        }

        if (score >= 90) {
            return "VERY_SECURE";
        }
        else if (score >= 80) {
            return "SECURE";
        }
        else if (score >= 70) {
            return "VERY_STRONG";
        }
        else if (score >= 60) {
            return "STRONG";
        }
        else if (score >= 50) {
            return "AVERAGE";
        }
        else if (score >= 25) {
            return "WEAK";
        }
        else {
            return "VERY_WEAK";
        }
    }

    public HJ87()
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) 
        {
            String pPasswordStr = in.nextLine();
            String safelevel = GetPwdSecurityLevel(pPasswordStr);
            System.out.println(safelevel);
        }
    }

    public static void main(String[] args) 
    {
        HJ87 solution = new HJ87();
    }
}