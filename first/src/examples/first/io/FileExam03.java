package examples.first.io;

import java.io.File;

public class FileExam03 {
    public static void main(String[] args) {
        File file = new File(".");
        File[] files = file.listFiles();
        for(File f : files){
            if(f.isDirectory()){
                System.out.println("[DIR]" + f.getAbsolutePath());
                System.out.println("fileSIze : " + fileLenth(f));
            }else{
                System.out.println("[FILE]" + f.getAbsolutePath());
                System.out.println("fileSIze : " + fileLenth(f));
            }
        }
    }

    private static long fileLenth(File f){
        int sum = 0;
        if(f.isDirectory()){
            File[] files = f.listFiles();
            if(files != null){
                for(File f2 : files){
                    sum += fileLenth(f2);
                }
            }
            return sum;
        }else{
            return f.length();
        }
    }
}
