package test.second;

/**
 * Created by weishuai on 2018/2/5.
 */
public class ThreadOfClass implements Runnable {

    private DoSomething doSomething;
    private String name;

    public ThreadOfClass(DoSomething doSomething, String name) {
        this.doSomething = doSomething;
        this.name = name;

    }

    @Override
    public void run() {
        doSomething.doThings(this.name);
    }
}
