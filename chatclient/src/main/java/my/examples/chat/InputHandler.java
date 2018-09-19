package my.examples.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;

public class InputHandler extends Thread {
    private BufferedReader br;
    private ChatClient chatClient;

    public InputHandler(ChatClient chatClient, BufferedReader br){
        this.chatClient = chatClient;
        this.br = br;
    }

    @Override
    public void run() {
        String line = null;
        try {
            while((line = br.readLine()) != null){
                //line 받으면 뿌려준다
                if(!line.contains(chatClient.getClientName() + ": ")) {
                    System.out.println(line);
                }
                System.out.print("> ");
            }
        } catch (SocketException e) {
        } catch (Exception e) { e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
