package my.examples.classfinder;

import java.util.List;

public class ClassLoaderTest05 {
    public static void main(String[] args) {
        String baseDir = "C:\\Users\\story\\JWPSProject\\miniwas\\target\\classes\\";
        ClassFinder classFinder = new ClassFinder(baseDir);
        List<String> allClasses = classFinder.findAllClasses();
        for(String className : allClasses){
            System.out.println(className);
        }
//
//        WebServletMapperManager wsmm = new WebServletMapperManager();
//        wsmm.findServletMap();
    }
}
