package examples.first.io;

import java.io.*;

public class IoExam05 {
    //키보드로부터 한줄씩 입력 받아서 파일에 한줄씩 출력
    // quit 라고 입력하면 프로그램은 종료
    public static void main(String[] args) {
        BufferedReader br = null;
        PrintWriter pw = null;
        try{
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            File file = new File("c:\\users\\story\\a\\b\\ioexam05.txt");
            pw = new PrintWriter(file);

            String line = null;
            while((line = br.readLine()) != null){
                if("quit".equals(line)) break;
                pw.write(line + "\n");
            }
        }catch (Exception ex){
            ex.printStackTrace();

        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.close();
        }
    }
}
