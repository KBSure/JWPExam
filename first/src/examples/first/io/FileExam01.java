package examples.first.io;

import java.io.File;

public class FileExam01 {
    public static void main(String[] args) {
//        C:\Users\story
        String fileName = "C:" + File.separator + "Users" + File.separator + "story" + File.separator + "filetest.md";
        File file = new File(fileName);
        if(file.exists()){
            System.out.println(fileName + "이 존재합니다");
        }
    }
}
