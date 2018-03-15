package third;

/**
 * 继承Thread的方式创建线程，实现卖票（锁代码块解决安全问题）
 * <p>
 * Created by WS on 2018/3/8.
 */
class Windows extends Thread {

    static int tickets = 100;
    static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {//本demo中，不能使用this对象。四个线程中的this不是同一个对象。所以要new一个相同对象
                if (tickets < 1) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "售票：" + tickets--);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Windows(String name) {
        super(name);
    }
}

public class TestWindowsByThread {
    public static void main(String[] args) {
        Windows w01 = new Windows("窗口一");
        Windows w02 = new Windows("窗口二");
        Windows w03 = new Windows("窗口三");
        Windows w04 = new Windows("窗口四");

        w01.start();
        w02.start();
        w03.start();
        w04.start();
    }
}
