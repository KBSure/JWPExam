package my.examples.etc;

import java.lang.reflect.Method;

public class ClassLoaderTest01 {
    public static void main(String[] args) throws Exception {
        Sample sample1 = new Sample();
        sample1.print();
        sample1.print("test");

        Class clazz = Class.forName("my.examples.etc.Sample");
        Method[] methods = clazz.getMethods();
//        Sample sample2 = (Sample) clazz.newInstance();
        for(Method method : methods){
            System.out.println(method);
        }
    }
}
