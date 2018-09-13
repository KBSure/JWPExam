package examples.first.io;

import java.io.*;

public class IoExam01 {
    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;

        try{
            String fileName = "c:\\users\\story\\filetest.md";
            File file = new File(fileName);
            if(file.exists() && !file.isDirectory()){
                in = new FileInputStream(file);
                String fileName2 = "c:\\users\\story\\filetest2.md";
                File dir = new File(fileName2 + "\\..");
                if(dir.exists() && dir.isDirectory()){
                    out = new FileOutputStream(fileName2);
                    int readData = 0;
                    while((readData = in.read()) != -1){
                        out.write(readData);
                    }
                }
            }
        }catch (Exception ex){

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
