package examples.first.io;

import java.io.File;

public class FileExam04 {
    public static void main(String[] args) {
        File file = new File("c:\\users\\story\\a\\b\\c\\d");
        if(!file.exists()){
            file.mkdirs();
        }
    }
}
