package ml.yihao;

import java.util.*;

class Student{
    private int grade;
    private String name;
    public static final Comparator<Student> INCREASE = new increase();
    public static final Comparator<Student> DECREASE = new decrease();
    public Student(String name, int grade) {this.name = name;
        this.grade = grade;
    }
    public String toString() {
        return name + " " + grade;
    }
    private static class increase implements Comparator<Student> {
        public int compare(Student v, Student w) {
            return w.grade - v.grade;
        }
    } 
    private static class decrease implements Comparator<Student> {
        public int compare(Student v, Student w) {
            return v.grade - w.grade;
        }
    }
}

/**
 * 题目描述
 * 查找和排序
 *
 * 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
 * 都按先录入排列在前的规则处理。
 *
 * 例示：
 * jack      70
 * peter     96
 * Tom       70
 * smith     67
 *
 * 从高到低  成绩
 * peter     96
 * jack      70
 * Tom       70
 * smith     67
 *
 * 从低到高
 *
 * smith     67
 *
 * jack      70
 *
 * Tom       70
 * peter     96
 *
 * 注：0代表从高到低，1代表从低到高
 *
 * 本题含有多组输入数据！
 * 输入描述:
 * 输入多行，先输入要排序的人的个数，然后分别输入他们的名字和成绩，以一个空格隔开
 *
 * 输出描述:
 * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 */
public class HJ68 {

    public HJ68() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = Integer.valueOf(in.next());
            int flag = Integer.valueOf(in.next());
            Student[] students = new Student[n];
            for (int i = 0; i < n; i++) {
                students[i] = new Student(in.next(), Integer.valueOf(in.next()));
            }
            if (flag == 1) {
                Arrays.sort(students, Student.DECREASE);
            }
            else {
                Arrays.sort(students, Student.INCREASE);
            }
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) 
    {
        HJ68 solution = new HJ68();
    } }