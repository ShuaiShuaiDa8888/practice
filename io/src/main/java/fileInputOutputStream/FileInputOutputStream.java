package fileInputOutputStream;

import java.io.*;

/**
 * TXT(纯文本文件)可用字符流；word文件要用字节流
 *
 * Created by WS on 2018/3/17.
 */
public class FileInputOutputStream {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String start = "E:\\weiShuai\\IO\\source.wmv";
        String end = "E:\\weiShuai\\IO\\target.wmv";
        copyOfInputOutputStream(start, end);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    public static void copyOfInputOutputStream(String start, String end) {
        File file1 = new File(start);
        File file2 = new File(end);
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file1);
            fileOutputStream = new FileOutputStream(file2);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = (fileInputStream.read(bytes))) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != fileInputStream) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fileOutputStream) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
