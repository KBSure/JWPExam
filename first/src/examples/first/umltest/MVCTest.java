package examples.first.umltest;

public class MVCTest {
    public static void main(String[] args) {
        MyDao myDao = new MyDaoImpl();
        MyService myService = new MyServiceImpl(myDao);
        MyController myController = new MyController(myService);

    }
}
