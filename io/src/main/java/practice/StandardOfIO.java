package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 从键盘上输入字符串，要求将读取到的整行字符串转大写输出然后继续执行输入操作；
 * 直至输入"e"或"exit"时，结束输入。
 * <p>
 * Created by WS on 2018/3/19.
 */
public class StandardOfIO {
    public static void main(String[] args) {
        InputStream in = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = null;
        while (true) {
            try {
                System.out.println("请输入字符串：");
                str = bufferedReader.readLine();
                if (str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit")) {
                    System.out.println("输入结束！");
                    break;
                } else {
                    str = str.toUpperCase();
                    System.out.println(str);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
