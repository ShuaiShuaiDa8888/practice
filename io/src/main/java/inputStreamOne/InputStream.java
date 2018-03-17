package inputStreamOne;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by WS on 2018/3/16.
 */
public class InputStream {

    public static void main(String[] args) {
        File file = new File("E:\\weiShuai\\IO\\source.txt");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1) {
                String str = new String(bytes, 0, len);
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
