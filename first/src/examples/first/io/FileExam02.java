package examples.first.io;

import java.io.File;

public class FileExam02 {
    public static void main(String[] args) {

        File file = new File(".\\test\\test.txt"); //은 JVM이 실행되고 있는 디렉토리
        System.out.println(file.getAbsolutePath());
    }
}
