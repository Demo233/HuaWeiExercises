package ml.yihao;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 题目描述
 * 问题描述：有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，线程3的功能就是向数组输出C，线程4的功能就是向数组输出D。要求按顺序向数组赋值ABCDABCDABCD，ABCD的个数由线程函数1的参数指定。[注：C语言选手可使用WINDOWS SDK库函数]
 * 接口说明：
 * void init();  //初始化函数
 * void Release(); //资源释放函数
 * unsignedint__stdcall ThreadFun1(PVOID pM)  ; //线程函数1，传入一个int类型的指针[取值范围：1 – 250，测试用例保证]，用于初始化输出A次数，资源需要线程释放
 * unsignedint__stdcall ThreadFun2(PVOID pM)  ;//线程函数2，无参数传入
 * unsignedint__stdcall ThreadFun3(PVOID pM)  ;//线程函数3，无参数传入
 * Unsigned int __stdcall ThreadFunc4(PVOID pM);//线程函数4，无参数传入
 * char  g_write[1032]; //线程1,2,3,4按顺序向该数组赋值。不用考虑数组是否越界，测试用例保证
 *
 * 输入描述:
 * 本题含有多个样例输入。
 * 输入一个int整数
 *
 * 输出描述:
 * 对于每组样例，输出多个ABCD
 */
public class HJ49 {

    public static void main(String[] args) {

        final LinkedList<Integer> inputList = new LinkedList<>();
        final AtomicBoolean isFinish = new AtomicBoolean(false);
        AppendTask t1 = new AppendTask("A");
        AppendTask t2 = new AppendTask("B");
        AppendTask t3 = new AppendTask("C");
        AppendTask t4 = new AppendTask("D");

        t1.addObserver(t2);
        t2.addObserver(t3);
        t3.addObserver(t4);
        t4.addObserver(t1);
        t4.setOnWorkListener(new AppendTask.OnWorkListener() {
            @Override
            public boolean onWorked(AppendTask task) {
                synchronized (inputList) {
                    //获取首个任务计数
                    Integer count = inputList.pollFirst();
                    if(count != null) {
                        count--;
                        if(count > 0) {
                            //因为还没有完成，再放回队列首位
                            inputList.offerFirst(count);
                        } else {
                            System.out.println("");
                            //输入完成和队列为空都成立时停止所有线程
                            if(inputList.isEmpty() && isFinish.get()) {
                                t1.exit();
                                t2.exit();
                                t3.exit();
                                t4.exit();
                            }
                        }
                    }
                    return inputList.isEmpty();
                }
            }
        });

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int count = scanner.nextInt();
            if(count <= 0) {
                continue;
            }
            //这里和工作线程不是同一个线程，需要加锁
            synchronized (inputList) {
                if (inputList.isEmpty()) {
                    t1.keepRunning();
                }
                inputList.offerLast(count);
            }
        }
        isFinish.set(true);
        scanner.close();
    }

    static class AppendTask extends Observable implements Runnable, Observer {

        private String fillStr;

        private volatile boolean running = true;

        private volatile boolean pause = true;

        private OnWorkListener listener;


        public AppendTask(String fillStr) {
            this.fillStr = fillStr;
        }

        @Override
        public void run() {
            while(running) {
                while(!pause) {
                    doWork();
                }
                if(!running) {
                    break;
                }
                synchronized(this) {
                    try {
                        wait();
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        protected void doWork() {
            System.out.print(fillStr);
            boolean ret = false;
            if(listener != null) {
                ret = listener.onWorked(this);
            }
            pause();
            super.setChanged();
            super.notifyObservers(ret);
        }

        public synchronized void pause() {
            pause = true;
        }

        public synchronized void keepRunning() {
            if(pause) {
                pause = false;
                notify();
            }
        }

        public synchronized void exit() {
            running = false;
            keepRunning();
        }

        @Override
        public void update(Observable o, Object arg) {
            if(arg instanceof Boolean) {
                Boolean b = (Boolean) arg;
                if(!b) {
                    keepRunning();
                }
            }
        }

        public void setOnWorkListener(OnWorkListener l) {
            listener = l;
        }

        interface OnWorkListener {
            boolean onWorked(AppendTask task);
        }
    }
}