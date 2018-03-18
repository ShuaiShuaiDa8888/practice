package fileReaderWriter;

import java.io.*;

/**
 * 若不对源文件做编码处理，读出来的就是乱码；因为TXT文本默认编码格式为ASIC；
 * 当对源文件进行编码设置后(另存为时修改编码方式为utf-8)，可解决此问题。
 *
 * TXT(纯文本文件)可用字符流；word文件要用字节流
 * Created by WS on 2018/3/18.
 */
public class FileReaderWriter {
    public static void main(String[] args) {
        File file1 = new File("E:\\weiShuai\\IO\\演讲稿.txt");
        File file2 = new File("E:\\weiShuai\\IO\\演讲稿1.txt");
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(file1);
            fileWriter = new FileWriter(file2);
            char[] chars = new char[24];
            int len;
            while ((len = fileReader.read(chars)) != -1) {
                fileWriter.write(chars, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != fileReader){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fileWriter){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
