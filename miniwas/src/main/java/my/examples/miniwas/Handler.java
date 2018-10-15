package my.examples.miniwas;

import my.examples.servlet.DefaultServlet;

import java.io.*;
import java.net.Socket;

public class Handler extends Thread{
    private Socket socket;

    // map2에 path와 servletInstance -> Handler에서 호출 올 때 인스턴스 존재하는지 검사해서 작성

    // Manager의 메서드를 호출해서 사용 -> Handler

    public Handler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        BufferedReader br = null;
        OutputStream out = null;
        PrintWriter pw = null;
        try {
            in = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(in));
            out = socket.getOutputStream();
            pw = new PrintWriter(out);

            Request request = new Request(in, br);
            Response response = new Response(out, pw);

            DefaultServlet defaultServlet = new DefaultServlet();
            defaultServlet.service(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            pw.close();
        }
    }
}
