package my.examples.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ChatServer extends Thread{
    private int port;
    private Set<PrintWriter> socketSet;

    public ChatServer(int port){
        this.port = port;
        this.socketSet = new CopyOnWriteArraySet<PrintWriter>();
    }

    public void addPrintWriter(PrintWriter out){
        socketSet.add(out);
    }

    public void deletePrintWriter(PrintWriter out){
        socketSet.remove(out);
    }

    public void broadcast(String msg){
        for(PrintWriter pw : socketSet){
            try{
                pw.println(msg);
                pw.flush();
            }catch (Exception ex){ex.printStackTrace();}
        }
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;

        try{
            serverSocket = new ServerSocket(port);
            while(true){
                Socket socket = serverSocket.accept();
                SocketHandler socketHandler = new SocketHandler(this, socket);
                socketHandler.start();
            }

        }catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
