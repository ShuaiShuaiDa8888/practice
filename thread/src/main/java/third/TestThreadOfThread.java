package third;

/**打印两份0——99之间的数据
 *
 * Created by WS on 2018/3/8.
 */
class PrintNum extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

    public PrintNum(String name) {
        super(name);
    }
}

public class TestThreadOfThread {
    public static void main(String[] args) {
        PrintNum pn01 = new PrintNum("线程一：");
        PrintNum pn02 = new PrintNum("线程二：");
        pn01.setPriority(Thread.MAX_PRIORITY);
        pn02.setPriority(Thread.MIN_PRIORITY);
        pn01.start();
        pn02.start();
    }
}
