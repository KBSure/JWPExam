package my.examples.etc;

public class ClassLoaderTest02 {
    public static void main(String[] args) throws Exception {
        Sample sample1 = new Sample();
        sample1.print();
        sample1.print("test");

        Class clazz = Class.forName("my.examples.etc.Sample");
        Sample sample2 = (Sample) clazz.newInstance();
        sample2.print();
        sample2.print("test");

//        for(Method method : methods){
//            System.out.println(method);
//        }
    }
}
