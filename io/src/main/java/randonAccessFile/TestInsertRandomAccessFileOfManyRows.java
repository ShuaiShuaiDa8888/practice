package randonAccessFile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 当原数据存在多行时实现插入操作
 *
 * Created by WS on 2018/3/22.
 */
public class TestInsertRandomAccessFileOfManyRows {

    public static void main(String[] args) {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(new File("E:\\weiShuai\\IO\\TestCopyOfRandomAccessFile.txt"), "rw");
            randomAccessFile.seek(5);
            byte[] bytes = new byte[10];
            int len;
            StringBuffer stringBuffer = new StringBuffer();
            while ((len = randomAccessFile.read(bytes)) != -1) {
                stringBuffer.append(new String(bytes, 0, len));
            }
            randomAccessFile.seek(5);
            randomAccessFile.write("ab".getBytes());
            randomAccessFile.write(stringBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (randomAccessFile != null){
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
