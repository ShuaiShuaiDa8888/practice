package FileBufferedInputOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 增加Logger后，会报如下问题：
 * SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
 * SLF4J: Defaulting to no-operation (NOP) logger implementation
 * SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
 *
 * Created by WS on 2018/3/18.
 */
public class BufferedInputOutputStream {

    public static final Logger LOGGER = LoggerFactory.getLogger(BufferedInputOutputStream.class);

    public static void main(String[] args) {
        String start = "E:\\weiShuai\\IO\\source.wmv";
        String end = "E:\\weiShuai\\IO\\target.wmv";
        long first = System.currentTimeMillis();
        try {
            copyFileByBufferedInputOutputStream(start, end);
            LOGGER.info("测试");
        } catch (IOException e) {
            e.printStackTrace();
        }
        long second = System.currentTimeMillis();
        System.out.println(second - first);
    }

    private static void copyFileByBufferedInputOutputStream(String start, String end) throws IOException {
        File file1 = new File(start);
        File file2 = new File(end);
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file1));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw e;
        } finally {
            if (null != bufferedOutputStream){
                bufferedOutputStream.close();
            }
            if(null != bufferedInputStream){
                bufferedInputStream.close();
            }
        }
    }

}
