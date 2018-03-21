package randonAccessFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机存取文件流实现文件复制
 *
 * Created by WS on 2018/3/22.
 */
public class testOfRandomAccessFile {
    public static void main(String[] args) {
        RandomAccessFile randomAccessFile01 = null;
        RandomAccessFile randomAccessFile02 = null;
        try {
            randomAccessFile01 = new RandomAccessFile(new File("E:\\weiShuai\\IO\\source.txt"), "r");
            randomAccessFile02 = new RandomAccessFile(new File("E:\\weiShuai\\IO\\testOfRandomAccessFile.txt"), "rw");
            byte[] bytes = new byte[10];
            int len;
            while ((len = randomAccessFile01.read(bytes)) != -1) {
                randomAccessFile02.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile02 != null) {
                try {
                    randomAccessFile02.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (randomAccessFile01 != null) {
                try {
                    randomAccessFile01.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
