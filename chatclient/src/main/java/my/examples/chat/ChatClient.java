package my.examples.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient extends Thread{
    private String host;
    private int port;
    private String clientName;

    public String getClientName() {
        return clientName;
    }

    public ChatClient(String host, int port){
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        Socket socket = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        BufferedReader keyboard = null;
        try{
            socket = new Socket(host, port);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());
            keyboard = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("채팅할 이름을 입력하세요.");
            this.clientName = keyboard.readLine();
            pw.println(clientName);
            pw.flush();

            InputHandler handler = new InputHandler(this, br);
            handler.start();

            String line = null;
            while((line = keyboard.readLine()) != null){
                if("/quit".equals(line)) break;
                pw.println(line);
                pw.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            pw.close();
            try {
                keyboard.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
