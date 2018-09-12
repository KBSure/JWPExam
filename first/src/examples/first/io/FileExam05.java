package examples.first.io;

import java.io.File;
import java.util.Calendar;

public class FileExam05 {
    //현재 날짜로 디렉토리 생성
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        String dirName = "c:\\users\\story\\a";
        String fileName = dirName + File.separator + calendar.get(Calendar.YEAR) + File.separator + (calendar.get(Calendar.MONTH) + 1) + File.separator + calendar.get(Calendar.DATE);
        File file = new File(fileName + File.separator + "test");
        if(!file.exists()){
            file.mkdirs();
        }
    }
}
