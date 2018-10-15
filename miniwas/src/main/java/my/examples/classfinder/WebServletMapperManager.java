package my.examples.classfinder;

import my.examples.miniwas.WebServlet;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebServletMapperManager {

    public Map<String, Class> findServletMap(){
        Map<String, Class> map = new HashMap<>();
        ClassFinder classFinder = new ClassFinder("C:\\Users\\story\\JWPSProject\\miniwas\\target\\classes\\");
        List<String> allClasses = classFinder.findAllClasses();
        for(String className : allClasses){
            try {
                Class clazz = Class.forName(className);
                Annotation annotation = clazz.getAnnotation(WebServlet.class);
                if(annotation != null){ // Annotation 있다.
                    map.put(className, clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map;
    }




}
