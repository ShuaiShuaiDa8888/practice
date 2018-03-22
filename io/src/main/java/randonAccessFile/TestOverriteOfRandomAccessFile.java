package randonAccessFile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 实现的是覆盖操作
 * 写入中文会干扰以前存在的数据
 *
 * Created by WS on 2018/3/22.
 */
public class TestOverriteOfRandomAccessFile {

    public static void main(String[] args) {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(new File("E:\\weiShuai\\IO\\TestCopyOfRandomAccessFile.txt"), "rw");
            System.out.println(randomAccessFile.getFilePointer());
            randomAccessFile.seek(5);
            randomAccessFile.write("ab".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
