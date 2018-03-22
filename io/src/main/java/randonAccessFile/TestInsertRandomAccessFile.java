package randonAccessFile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile实现插入操作
 * Created by WS on 2018/3/22.
 */
public class TestInsertRandomAccessFile {
    public static void main(String[] args) {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(new File("E:\\weiShuai\\IO\\TestCopyOfRandomAccessFile.txt"), "rw");
            randomAccessFile.seek(5);
            String str = randomAccessFile.readLine();
            randomAccessFile.seek(5);
            randomAccessFile.write("ab".getBytes());
            randomAccessFile.write(str.getBytes());
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
