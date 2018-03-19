package printStreamOrPrintWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by WS on 2018/3/20.
 */
public class PrintStreamOrPrintWriter {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File("E:\\weiShuai\\IO\\PrintStreamOrPrintWriter.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintStream printStream = new PrintStream(fileOutputStream, true);
        if (null != printStream) {
            System.setOut(printStream);
        }
        String[] str = {
                "白", "日", "依", "山", "尽", "黄", "河", "入", "海", "流", "欲", "穷", "千", "里", "目", "更", "上", "一", "层", "楼"
        };
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
    }
}
