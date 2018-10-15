package my.examples.servlet;

import my.examples.miniwas.Request;
import my.examples.miniwas.Response;

import java.io.*;

public class DefaultServlet {

    public void service(Request request, Response response) {
        //path 구하기

        String webPath = request.getPath();
        if("/".equals(webPath)){
            webPath = "/index.html";
        }

        String path = "c:/users/story/tmp/www" + webPath;

        //file 있으면 file 내용 읽어서 response에 쓰기
        OutputStream out = response.getOut();
        PrintWriter pw = response.getPw();
        PrintWriter pw2 = new PrintWriter(out);

        File file = new File(path);
        FileInputStream fis = null;
        if(file.exists()){
            byte[] buffer = new byte[1024];
            try {
                pw.println("HTTP/1.1 200 OK");
                pw.println("Content-Length: " + file.length());
                pw.println("Content-Type: " + "text/html; charset=UTF-8");
                pw.println("");
                pw.flush();

                fis = new FileInputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(System.out);
                int readCount = 0;
                while((readCount = fis.read(buffer)) != -1){
                    bos.write(buffer, 0, readCount);
                    out.write(buffer, 0, readCount);
                    out.flush();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally{
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            System.out.println("here");
            pw.println("HTTP/1.1 200 OK");
//            pw.println("Content-Type: text/html; charset=UTF-8");
//            pw.println("");
            String s = "<h1>hello</h1>";
            pw.println("Content-Type: text/html");
            pw.println("Content-Length: "+s.length());
            pw.println("");
            pw.println(s);
            pw.flush();
        }

        //file 없으면 404 error Page 보내기
    }
}
