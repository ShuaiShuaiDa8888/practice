package fifth;

/**
 * 两个储户分别向同一个账户存3000元，每次存一千，存三次，每次打印账户余额
 * <p>
 * Created by WS on 2018/3/11.
 */
class Money implements Runnable {

    public int money = 0;

    @Override
    public void run() {
        for (int i = 3; i > 0; i--) {
            synchronized (this) {
                money += 1000;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "存钱后账户余额：" + money);
            }
        }
    }
}

public class MoneyByRunnbleOfClassblock {

    public static void main(String[] args) {
        Money money = new Money();

        Thread t1 = new Thread(money);
        Thread t2 = new Thread(money);
        t1.setName("张三");
        t2.setName("李四");

        t1.start();
        t2.start();
    }

}
