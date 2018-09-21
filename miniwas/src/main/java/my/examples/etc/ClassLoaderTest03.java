package my.examples.etc;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderTest03 {
    public static void main(String[] args) throws Exception{
        Sample s1 = new Sample();
        s1.print();
        s1.print("world");

        addPath("c:/Users/story/tmp/classes");

        Class clazz = Class.forName("my.MyData");
        Object obj = clazz.newInstance();
        Method[] methods = clazz.getMethods();
        for(Method m : methods){
            System.out.println(m.getName());
        }
    }

    public static void addPath(String s) throws Exception {
        File f = new File(s);
        URL u = f.toURI().toURL();
        URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        Class urlClass = URLClassLoader.class;
        Method method = urlClass.getDeclaredMethod("addURL", new Class[]{URL.class});
        method.setAccessible(true);
        method.invoke(urlClassLoader, new Object[]{u});
    }
}
