package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
 * 要求输出所有火车出站的方案，以字典序排序输出。
 * 输入描述:
 * 有多组测试用例，每一组第一行输入一个正整数N（0
 *
 * 输出描述:
 * 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 */
public class HJ77 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
           s.nextLine();
           String[] arr = s.nextLine().split(" ");
           List<List<String>> list = new ArrayList<>();
           huisu(0, arr, new Stack<>(), new ArrayList<>(), list);
           list.sort((o1, o2) -> {
            int iTemp = 0;
            for (int i = 0; i < o1.size(); i++) {
                if (o1.get(i).compareTo(o2.get(i)) != 0) {
                    iTemp = i;
                    break;
                }
            }
            return o1.get(iTemp).compareTo(o2.get(iTemp));
        });
           list.forEach(o-> System.out.println(String.join(" ",o)));
        }
    }

    private static void huisu(int start, String[] arr, Stack<String> stack, List<String> listTemp, List<List<String>> list) {
        if (start == arr.length) {
            if (!stack.isEmpty()) {
                String peek = stack.peek();
                listTemp.add(peek);
                stack.pop();
                huisu(start, arr, stack, listTemp, list);
                stack.push(peek);//回溯
                listTemp.remove(listTemp.size() - 1);//回溯
            } else {
                list.add(new ArrayList<>(listTemp));
            }
            return;
        }
        ///////可入可出的情况
        //入栈
        stack.push(arr[start]);
        huisu(start + 1, arr, stack, listTemp, list);
        stack.pop();
        //出栈
        if (!stack.isEmpty()) {
            String peek = stack.peek();
            stack.pop();
            listTemp.add(peek);
            huisu(start, arr, stack, listTemp, list);
            listTemp.remove(listTemp.size() - 1);//回溯
            stack.push(peek);//回溯
        }
    }
}
