package ml.yihao;

import java.util.Scanner;
import java.util.Stack;

/**
 * 题目描述
 * 输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
 *
 * 链表的值不能重复。
 *
 * 构造过程，例如
 *
 * 1 <- 2
 *
 * 3 <- 2
 *
 * 5 <- 1
 *
 * 4 <- 5
 *
 * 7 <- 2
 *
 * 最后的链表的顺序为 2 7 3 1 5 4
 *
 * 删除 结点 2
 *
 * 则结果为 7 3 1 5 4
 *
 * 链表长度不大于1000，每个节点的值不大于10000。
 * 本题含有多组样例。
 *
 * 输入描述:
 * 1 输入链表结点个数
 * 2 输入头结点的值
 * 3 按照格式插入各个结点
 * 4 输入要删除的结点的值
 *
 * 输出描述:
 * 输出删除结点后的序列，每个数后都要加空格
 */
public class HJ48 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext())
		{
			//输入节点数
			int nodeNum = in.nextInt();
			//输入头节点的值
			int headVal = in.nextInt();
			//构造头节点
			Node pHead = new Node(headVal);
			for(int i = 0;i < nodeNum - 1;i ++)
			{
				//插入节点值
				int nextVal = in.nextInt();
				//前一节点值
				int preVal = in.nextInt();
				//插入节点
				insert(pHead,preVal,nextVal);
			}
			int deleteVal = in.nextInt();
			pHead = removeNode(pHead, deleteVal);
			while(pHead.next != null)
			{
				System.out.print(pHead.val + " ");
				pHead = pHead.next;
			}
			System.out.println(pHead.val + " ");
		}
	}
	/*
	 参数 pHead 头节点
	 preVal 上一节点值
	 nextVal 插入节点值 
	*/
	public static void insert(Node pHead,int preVal,int nextVal)
	{
		Node pNext = new Node(nextVal);
		Node pCurrent = pHead;
		while(pCurrent != null)
		{
			if(pCurrent.val == preVal)
			{
				pNext.next = pCurrent.next;
				pCurrent.next = pNext;
				break;
			}
			pCurrent = pCurrent.next;
		}
	}
	public static Node removeNode(Node pHead,int val)
	{
		Stack<Node> stack = new Stack<Node>();
		while(pHead != null)
		{
			if(pHead.val != val)
			{
				stack.push(pHead);
			}
			pHead = pHead.next;
		}
		while(!stack.isEmpty())
		{
			stack.peek().next = pHead;
			pHead = stack.pop();
		}
		return pHead;
	}
}
class Node
{
	public int val;
	public Node next;
	public Node(int val)
	{
		this.val = val;
	}
}