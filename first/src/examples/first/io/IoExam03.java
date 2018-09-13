package examples.first.io;

import java.io.*;

public class IoExam03 {
    public static void main(String[] args) throws Exception{
        String str = "hello world!";
        byte[] buffer = str.getBytes();
        InputStream in = new ByteArrayInputStream(buffer);
        OutputStream out = new FileOutputStream("c:\\users\\story\\buffer.txt");

        CopyUtil.copy(in, out);

        InputStream in2 = new FileInputStream("c:\\users\\story\\buffer.txt");
        OutputStream out2 = new ByteArrayOutputStream();

        CopyUtil.copy(in2, out2);

        String str2 = ((ByteArrayOutputStream) out2).toString();
        System.out.println(str2);

    }
}
