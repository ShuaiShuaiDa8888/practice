import org.junit.Test;

import java.io.*;

/**
 * 对象流的输入和输出
 * 对象流输出会乱码，将输出的对象再次输入到程序不乱码
 * 如果只有内部类实现序列化，而外部封装类没有实现序列化接口，就会在对内部类进行序列化的时候报出异常
 * 被static和transient修饰的属性不能被序列化
 * Created by WS on 2018/3/21.
 */
public class TestOfObjectInputOrOutputStream implements Serializable {
    private static final long serialVersionUID = 2L;
    @Test
    public void test(){
        //对象流的写
//        objectOutputStream();
        //对象流的读
        objectInputStream();
    }

    private class Persons implements Serializable {
        private static final long serialVersionUID = 6640141963188343567L;
        String name;
        Integer age;

        public Persons(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Persons{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    /**
     * 输出对象流到文件
     */
    private void objectOutputStream()  {
        Persons Persons01 = new Persons("张三", 21);
        Persons Persons02 = new Persons("李四", 22);
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("E:\\weiShuai\\IO\\objectOutputStream.txt")));
            objectOutputStream.writeObject(Persons01);
            objectOutputStream.flush();
            objectOutputStream.writeObject(Persons02);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != objectOutputStream) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void objectInputStream() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(new File("E:\\weiShuai\\IO\\objectOutputStream.txt")));
            Persons Persons01 = (Persons)objectInputStream.readObject();
            Persons Persons02 = (Persons)objectInputStream.readObject();
            System.out.println(Persons01 + "\n" + Persons02);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (null != objectInputStream){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
