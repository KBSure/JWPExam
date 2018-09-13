package examples.first.io;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class IoExam02 {
    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;

        try{
            String fileName = "c:\\users\\story\\filetest.md";
            File file = new File(fileName);
            if(file.exists() && !file.isDirectory()){
                in = new FileInputStream(file);
                String fileName2 = "c:\\users\\story\\filetest3.md";
                File dir = new File(fileName2 + "\\..");
                File file2 = new File(fileName2);
                if(dir.exists() && dir.isDirectory()){
                    out = new FileOutputStream(file2);
                    if(file2.exists()){
                        throw new FileAlreadyExistsException(fileName2);
                    }
                    byte[] buffer = new byte[1024];
                    int readData = 0;
                    while((readData = in.read(buffer)) != -1){
                        out.write(buffer, 0, readData);
                    }
                }
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
