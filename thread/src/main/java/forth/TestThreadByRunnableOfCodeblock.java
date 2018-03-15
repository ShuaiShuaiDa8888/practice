package forth;

/**
 * 通过实现Runnable的方式实现多线程。打印0——100间的数据
 * <p>
 * Created by WS on 2018/3/9.
 */
//创建一个实现Runnable接口的类
class PrintNum implements Runnable {

    private int tickets = 100;

    //重写run()
    @Override
    public void run() {
        //子线程执行的代码
        while (true) {
            //锁代码块实现线程安全
            synchronized (this) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + tickets--);
                    try {
                        Thread.sleep(10);//让抢到资源的线程睡眠0.01s,
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

public class TestThreadByRunnableOfCodeblock {
    public static void main(String[] args) {
        PrintNum pn = new PrintNum();   //创建一个Runnable接口实现类的对象
        Thread t1 = new Thread(pn);     //将此对象作为形参传递给Thread类的构造器中，创建Thread类的对象，即线程
        t1.setName("线程一");          //将t1线程命名
        Thread t2 = new Thread(pn);
        t2.setName("线程二");
        Thread t3 = new Thread(pn);
        t3.setName("线程三");
        //启动线程必须用start()。run()只是调用方法而不是启动线程
        t1.start();     //启动线程并执行run()
        t2.start();
        t3.start();
    }
}
