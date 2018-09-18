package my.examples.chat;

import java.io.*;
import java.net.Socket;

public class SocketHandler extends Thread{
    private ChatServer chatServer;
    private Socket socket;
    private String name;

    public SocketHandler(ChatServer chatServer, Socket socket){
        this.chatServer = chatServer;
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("SocketHandler start");
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());

            this.name = br.readLine();
            chatServer.addPrintWriter(pw);
            chatServer.broadcast(name + "님이 입장하셨습니다.");

            String line = null;
            while((line = br.readLine()) != null){
                chatServer.broadcast(name + ": " + line);
            }
//            while((line = br.readLine()) != null){
//                pw.write(line + "\r\n");
//                pw.flush();
//            }
        } catch (IOException e) {
            System.out.println("Chat Handler close");
        }finally {
            System.out.println("Chat Handler finally");
            chatServer.broadcast(name + "님이 퇴장하셨습니다.");
            try{
                br.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                pw.close();
            }catch (Exception ex){ex.printStackTrace();}
        }
    }
}
