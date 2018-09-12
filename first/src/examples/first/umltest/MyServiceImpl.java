package examples.first.umltest;

public class MyServiceImpl implements MyService {
    private MyDao myDao;

    public MyServiceImpl(MyDao myDao){
        this.myDao = myDao;
    }
    @Override
    public void hi() {
        System.out.println("hi");
    }
}
