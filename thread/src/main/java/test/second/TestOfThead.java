package test.second;

/**
 * Created by weishuai on 2018/2/5.
 */
public class TestOfThead {
    public static void main(String[] args) {
        DoSomething doSomething = new DoSomething();

        ThreadOfClass threadOfClassZhang = new ThreadOfClass(doSomething, "张三");
        ThreadOfClass threadOfClassLi = new ThreadOfClass(doSomething, "李四");
        for (int i = 0; i < 5; i++) {
            Thread tZhang = new Thread(threadOfClassZhang, "ThreadZhang");
            Thread tLi = new Thread(threadOfClassLi, "ThreadLi");
            tZhang.start();
            tLi.start();

        }
    }
}
