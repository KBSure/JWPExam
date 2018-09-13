package examples.first.io;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class CopyUtil {
    public static void copy(InputStream in, OutputStream out){
        try{
            byte[] buffer = new byte[1024];
            int readData = 0;
            while((readData = in.read(buffer)) != -1){
                out.write(buffer, 0, readData);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
