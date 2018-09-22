package my.examples.miniwas;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connect {
    private int port;

    public Connect(int port){
        this.port = port;
    }


    public void run(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);

            while(true){
                System.out.println("waiting...");
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.run();
            }

        } catch (IOException e) {
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
