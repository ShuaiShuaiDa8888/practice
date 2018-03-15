package test.second;

/**
 * Created by weishuai on 2018/2/5.
 */
public class DoSomething {
    public String name;

    public void doThings(String name) {
        synchronized (this) {
            this.name = name;
            System.out.println(Thread.currentThread().getId() + "大家好，我是：" + this.name);
        }
    }
}
