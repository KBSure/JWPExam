package my.examples.etc;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderTest04 {
    private static String baseDir = "C:\\Users\\story\\JWPSProject\\miniwas\\target\\classes\\";
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Enumeration<URL> roots = classLoader.getResources("");
        while(roots.hasMoreElements()){
            URL url = roots.nextElement();
            File root = new File(url.getPath());
            if(root.isDirectory()){
                printDirectory(root);
            }else{
                printFile(root);
            }
        }
    }

    private static void printDirectory(File dir){
        for(File f : dir.listFiles()){
            if(f.isDirectory()){
                printDirectory(f);
            }else{
                printFile(f);
            }
        }
    }

    private static void printFile(File file){
        printClassName(file.getPath());
    }

    private static void printClassName(String path){
        path = path.substring(baseDir.length());
        path = path.replace("\\",".");
        path = path.substring(0, path.lastIndexOf("."));
        System.out.println(path);
    }
}
