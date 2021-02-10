package ml.yihao;

import java.util.*;

/**
 * 题目描述
 * 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
 *
 * 链表结点定义如下：
 *
 * struct ListNode
 *
 * {
 *
 * int       m_nKey;
 *
 * ListNode* m_pNext;
 *
 * };
 *
 *
 *
 * 正常返回倒数第k个结点指针，异常返回空指针
 *
 * 本题有多组样例输入。
 *
 *
 * 输入描述:
 * 输入说明
 * 1 输入链表结点个数
 * 2 输入链表的值
 * 3 输入k的值
 *
 * 输出描述:
 * 输出一个整数
 */
public class HJ51 {

    private int size; 
    private ListNode head;

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }  

    public HJ51(int size, int[] array) {
        this.size = size;
        this.head = new ListNode(array[0]);

        ListNode p = head;
        for (int i = 1; i < size; i++) {
            p.next = new ListNode(array[i]);
            p = p.next;
        }
    }

    public ListNode findKthToTail(int k) {
        // 题目没有指出，无法理解
        if (k == 0) return new ListNode(0);
        if (k < 0 || k > size) return null;
        k = size - k;
        ListNode p = head;
        while (k != 0) {
            p = p.next;
            k--;
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = Integer.parseInt(in.next());
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(in.next());
            }
            int k = Integer.parseInt(in.next());
            HJ51 solution = new HJ51(n, array);
            ListNode node = solution.findKthToTail(k);
            if (node != null) {
                System.out.println(node.val);
            }
            else {
                System.out.println();
            }
        }
    } 
}