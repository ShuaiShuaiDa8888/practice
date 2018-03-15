package forth;

/**
 * Created by WS on 2018/3/10.
 */
class WindowsOfCodeblock implements Runnable {
    int tickets = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized(obj) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "售票：" + tickets--);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}

public class TestWindowsByRunnableOfCodeblock {
    public static void main(String[] args) {
        WindowsOfCodeblock w = new WindowsOfCodeblock();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
