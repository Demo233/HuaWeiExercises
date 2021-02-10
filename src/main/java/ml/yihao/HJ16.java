package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
 * 主件	附件
 * 电脑	打印机，扫描仪
 * 书柜	图书
 * 书桌	台灯，文具
 * 工作椅	无
 * 如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第 5 等最重要。他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。他希望在不超过 N 元（可以等于 N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
 *     设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为：
 * v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ … +v[j k ]*w[j k ] 。（其中 * 为乘号）
 *     请你帮助王强设计一个满足要求的购物单。
 *
 *
 *
 *
 * 输入描述:
 * 输入的第 1 行，为两个正整数，用一个空格隔开：N m
 *
 * （其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
 *
 *
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 *
 *
 * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 *
 *
 *
 *
 * 输出描述:
 *  输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。
 */
public class HJ16 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //获取背包容量
        int m = sc.nextInt();
        //获取物品数量
        int n = sc.nextInt();
 
        int[] v = new int[n+1];
        int[] p = new int[n+1];
 
        int[] q = new int[n+1];
        int groups = 0;
        for(int i = 1; i<=n; i++){
            v[i] = sc.nextInt();
            p[i] = sc.nextInt();
            q[i] = sc.nextInt();
            if(q[i] == 0) {
                //根据主件个数，决定分多少组。即背包问题的物品数量
                groups++;
            }
        }
 
        //分组
        //定义容量数组
        int[][] _v = new int[groups +1][4];
        //定义价值数组
        int[][] _p = new int[groups +1][4];
        //得到赋值后的数组
        processData(q, v, p, _v, _p);
 
        int gc = _v.length;
        //gc为背包问题实际上的商品数量-1，这样方便后面循环i< gc
        //System.out.println("gc="+gc);
        //m为背包问题实际上的容积上限，故意m+1,这样取值可以包括m
        int[][] r = new int[gc][m+1];
        //声明一个最大容量最大价值的数组
        for(int i = 1; i< gc; i++){//商品数量
            for(int j = 1; j<= m; j++){//商品体积
                //背包问题-缩短为子问题-固定状态-假设不放第i件商品，此时实际占用容量为j，价值最大
                int max = r[i-1][j];//假设为不装i的价值最大
                //遍历看装i个商品的时候，里面附件和主件数量的综合
                for (int t = 1; t < _v[i].length; t++) {
                    //System.out.println("t="+t);
                    //取processData过程赋的值
                    int tempv = _v[i][t];//当背包装i组商品时，t=主件+附件数量，实际体积
                    int tempp = _p[i][t];//装第i组商品时，实际价值
                    if(tempv != 0 && tempv <= j) {
                        int maxBak = r[i - 1][j - tempv] + tempp;//假设装i的时候价值最大
                        max = Math.max(max, maxBak);//验证假设，求实际的最大值
                    }
                }
                //此值就是在j容量下装i组商品的真正最大价值
                r[i][j] = max;
                //System.out.print("r[i][j] = max:"+max);
            }
        }
        //那么本题实际有gc-1组商品，容量为m.其最大值为r[gc-1][m]
        System.out.println(r[gc -1][m]);
    }
    //记得审题。如果 q>0 ，表示该物品为附件， q 是所属主件的编号
    private static void processData(int[] m, int[] v, int[] p, int[][] _v, int[][] _p) {
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 1; i < m.length; i++) {
            if(m[i] == 0 ) {
                //第i件为主件
                if(!groups.containsKey(i)) {
                    List<Integer> temp = new ArrayList<Integer>();
                    //记录此商品序号
                    temp.add(i);
                    //以商品序号-即主件编号当成key
                    groups.put(i, temp);
                }
 
            }else {
                //System.out.println("aaaa  件商品的附件编号为m[i]="+m[i] + ",第i件商品="+i);
                //第i件q>0为附件
                if (groups.containsKey(m[i])) {
                    ////记录附件所属的主件编号一样的话
                    //取出value集合
                    List<Integer> list = groups.get(m[i]);
                    //增加此附件商品序号
                    list.add(i);
                }else {
                    List<Integer> temp = new ArrayList<Integer>();
                    //记录附件所属的主件编号-也即自己主件的商品序号
                    temp.add(m[i]);
                    //记录此附件商品序号
                    temp.add(i);
                    //记录附件所属的主件编号
                    groups.put(m[i], temp);
                }
            }
        }
        int index = 1;
        //遍历得出所有的大组，大组里面包括主件商品序号，有附件的还包括附件商品序号
        for(List<Integer> list : groups.values()) {
 
            int size = list.size();
            if(size == 1) {
                //说明只有主件，没有附件。那么给数组赋值
                _v[index][1] = v[list.get(0)];//v[list.get(0)]主件的体积
                _p[index][1] = p[list.get(0)] * v[list.get(0)];//list.get(0)] * v[list.get(0) 记得审题，本题中说每件物品的价格与重要度的乘积的总和最大
                //那么主件的价值就是  价格v[list.get(0)*重要度  p[list.get(0)
 
            }else if (size == 2) {
                //有一个主件一个附件，可以有两种购买方案
 
 
               //第一种，只买主件
                _v[index][1] = v[list.get(0)];
                _p[index][1] = p[list.get(0)] * v[list.get(0)];
 
                //第二种，既买主件也买附件
                _v[index][2] = v[list.get(0)] + v[list.get(1)];
                _p[index][2] = p[list.get(0)] * v[list.get(0)] + p[list.get(1)] * v[list.get(1)];
            }else {
 
                //System.out.println("size="+size);
                //有一个主件二个附件，可以有三种购买方案
 
                //第一种，只买主件
                _v[index][1] = v[list.get(0)];
                _p[index][1] = p[list.get(0)]* v[list.get(0)];
 
                //第二种，既买主件也买一个附件
                //这里要特别注意，搭配1：主件+附件一  搭配2：主件+附件2，所以要算两次取最大值赋值
                int vMax = v[list.get(0)] + v[list.get(1)];//主件+附件一
                int vMaxBak = v[list.get(0)] + v[list.get(2)];//主件+附件二
                _v[index][2] = Math.max(vMax,vMaxBak);//取最大搭配
 
 
                int pMax = p[list.get(0)] * v[list.get(0)] + p[list.get(1)] * v[list.get(1)];//主件+附件一
                int pMaxBak = p[list.get(0)] * v[list.get(0)] + p[list.get(2)] * v[list.get(2)];//主件+附件二
                _p[index][2] = Math.max(pMax,pMaxBak);//取最大搭配
 
                //第三种，既买主件也买二个附件
                _v[index][3] = v[list.get(0)] + v[list.get(1)] + v[list.get(2)];
                _p[index][3] = p[list.get(0)] * v[list.get(0)]  + p[list.get(1)]* v[list.get(1)] + p[list.get(2)]* v[list.get(2)];
 
 
            }
            index++;
        };
    }
 
}