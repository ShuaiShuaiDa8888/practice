package inputStreamReaderAndOutputStreamWriter;

import java.io.*;

/**
 * 转换流：InputStreamReader, OutputStreamWriter
 *
 * Created by WS on 2018/3/18.
 */
public class ConvertIO {
    public static void main(String[] args) {

        File file1 = new File("E:\\weiShuai\\IO\\演讲稿.txt");
        File file2 = new File("E:\\weiShuai\\IO\\演讲稿2.txt");

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileInputStream = new FileInputStream(file1);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);

            fileOutputStream = new FileOutputStream(file2);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            char[] chars = new char[10];
            int len;
            while ((len = (bufferedReader.read(chars))) != -1) {
                bufferedWriter.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bufferedWriter) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != bufferedReader){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
