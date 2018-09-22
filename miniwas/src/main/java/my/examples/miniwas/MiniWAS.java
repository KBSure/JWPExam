package my.examples.miniwas;

public class MiniWAS extends Thread{
    @Override
    public void run() {
        Connect connect = new Connect(8888);
        connect.run();
    }
}
