package dataInputOrOutputStream;

import java.io.*;

/**
 * 数据流：用来处理基本数据类型、String、字节数组等
 * 写进文件会乱码;
 * 用对应着写进去的方法读出来，能正常显示
 * <p>
 * Created by WS on 2018/3/20.
 */
public class DataInputOrOutputStream {
    public static void main(String[] args) {
        //写数据流
        //dataOutputStream();
        //读数据流
        dataInputStream();
    }

    private static void dataOutputStream() {
        DataOutputStream dataOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\weiShuai\\IO\\DataInputOrOutputStream.txt"));
            dataOutputStream = new DataOutputStream(fileOutputStream);
            dataOutputStream.writeUTF("我爱我家");
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeLong(12345678);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void dataInputStream() {
        try {
            FileInputStream fileInputStream = new FileInputStream("E:\\weiShuai\\IO\\DataInputOrOutputStream.txt");
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            String str = dataInputStream.readUTF();
            boolean flag = dataInputStream.readBoolean();
            long l = dataInputStream.readLong();
            System.out.println(str + "  " + flag + "  " + l);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
