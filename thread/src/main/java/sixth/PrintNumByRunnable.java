package sixth;

/**
 * 两个线程交替打印1—100。
 * <p>
 * Created by WS on 2018/3/11.
 */
class PrintNum implements Runnable {

    public int num = 1;

    @Override
    public void run() {
        while(true) {
            synchronized(this) {
                notify();
                if (num <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                    try {
                        wait();
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

public class PrintNumByRunnable {
    public static void main(String[] args) {
        PrintNum printNum = new PrintNum();

        Thread t1 = new Thread(printNum);
        Thread t2 = new Thread(printNum);
        t1.setName("甲");
        t2.setName("乙");

        t1.start();
        t2.start();
    }
}
