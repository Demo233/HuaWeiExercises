package ml.yihao;

import java.util.Scanner;

/**
 * 题目描述
 * 有一个大小的数据表，你会依次进行以下5种操作：
 * 1.输入和，初始化大小的表格。
 * 2.输入x_1x
 * 1
 * ​
 *  、y_1y
 * 1
 * ​
 *  、x_2x
 * 2
 * ​
 *  、y_2y
 * 2
 * ​
 *  ，交换坐标在(x_1,y_1)(x
 * 1
 * ​
 *  ,y
 * 1
 * ​
 *  )和(x_2,y_2)(x
 * 2
 * ​
 *  ,y
 * 2
 * ​
 *  )的两个数。
 * 3.输入，在第行左边添加一行。
 * 4.输入，在第列上方添加一列。
 * 5.输入、，查找坐标为的单元格的值。
 * 请编写程序，判断对表格的各种操作是否合法。
 *
 * 详细要求:
 *
 * 1.数据表的最大规格为9行*9列，对表格进行操作时遇到超出规格应该返回错误。
 * 2.对于插入操作，如果插入后行数或列数超过9了则应返回错误。如果插入成功了则将数据表恢复至初始化的大小，多出的数据则应舍弃。
 * 3.所有输入坐标操作，对大小的表格，行号坐标只允许0~m-1，列号坐标只允许0~n-1。超出范围应该返回错误。
 *
 * 本题含有多组样例输入！
 * 输入描述:
 * 输入数据按下列顺序输入：
 * 1 表格的行列值
 * 2 要交换的两个单元格的行列值
 * 3 输入要插入的行的数值
 * 4 输入要插入的列的数值
 * 5 输入要查询的单元格的坐标
 *
 * 输出描述:
 * 输出按下列顺序输出：
 * 1 初始化表格是否成功，若成功则返回0， 否则返回-1
 * 2 输出交换单元格是否成功
 * 3 输出插入行是否成功
 * 4 输出插入列是否成功
 * 5 输出查询单元格数据是否成功
 */
public class HJ83 {

	static final Scanner SC = new Scanner(System.in);

	public static void main(String...args) {
		while (SC.hasNextInt()) {
			HJ83 operator = new HJ83();
			System.out.println(operator.init());
			System.out.println(operator.swap());
			System.out.println(operator.insertRows());
			System.out.println(operator.insertCols());
			System.out.println(operator.checkGet());
		}
	}

	static final int MAX_ROWS = 9;
	static final int MAX_COLS = 9;

	int rows;
	int cols;

	int init() {
		int rows = SC.nextInt();
		int cols = SC.nextInt();
		if (rows <= 0 || cols <= 0 || rows > MAX_ROWS || cols > MAX_COLS)
			return -1;
		this.rows = rows;
		this.cols = cols;
		return 0;
	}

	int swap() {
		int row1 = SC.nextInt();
		int col1 = SC.nextInt();
		int row2 = SC.nextInt();
		int col2 = SC.nextInt();
		if (row1 < 0 || row1 >= rows || col1 < 0 || col1 >= cols)
			return -1;
		if (row2 < 0 || row2 >= rows || col2 < 0 || col2 >= cols)
			return -1;
		return 0;
	}

	int insertRows() {
		int row = SC.nextInt();
		if (row < 0 || row >= rows || rows == MAX_ROWS)
			return -1;
		return 0;
	}

	int insertCols() {
		int col = SC.nextInt();
		if (col < 0 || col >= cols || cols == MAX_COLS)
			return -1;
		return 0;
	}

	int checkGet() {
		int row = SC.nextInt();
		int col = SC.nextInt();
		if (row < 0 || row >= rows || col < 0 || col >= cols)
			return -1;
		return 0;
	}

}
