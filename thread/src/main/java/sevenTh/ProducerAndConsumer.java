package sevenTh;

/**
 * 生产者消费者模式(20个产品)
 * <p>
 * Created by WS on 2018/3/11.
 */
class Clerk {//店员
    int product;

    public synchronized void addProduct() {
        if (product >= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "生产第" + ++product + "个商品");
            notifyAll();
        }
    }

    public synchronized void subProduct() {
        if (product <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(Thread.currentThread().getName() + "消费第" + product-- +"个商品");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifyAll();
        }
    }
}

class Producer implements Runnable {//生产者
    Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产商品");
        while (true) {
            clerk.addProduct();
        }
    }
}

class Consumer implements Runnable {
    Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            clerk.subProduct();
        }
    }
}

public class ProducerAndConsumer {
    public static void main(String[] args) {
    Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Producer producer02 = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        Thread t3 = new Thread(producer02);
        t1.setName("生产者一");
        t2.setName("消费者一");
        t3.setName("生产者二");

        t1.start();
        t2.start();
        t3.start();
    }
}
