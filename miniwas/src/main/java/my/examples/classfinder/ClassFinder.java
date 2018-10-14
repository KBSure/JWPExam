package my.examples.classfinder;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassFinder {
    private static String baseDir;

    public ClassFinder(String baseDir){
        this.baseDir = baseDir;
    }

    public List<String> findAllClasses(){
        List<String> list = new ArrayList<>();
        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            Enumeration<URL> roots = classLoader.getResources("");
            while(roots.hasMoreElements()){
                URL url = roots.nextElement();
                File root = new File(url.getPath());
                if(root.isDirectory()){
                    scanDirectory(list, root);
                }else{
                    addFile(list, root);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void scanDirectory(List<String> list, File dir){
        for(File f : dir.listFiles()){
            if(f.isDirectory()){
                scanDirectory(list, f);
            }else{
                addFile(list, f);
            }
        }
    }

    private void addFile(List<String> list, File file){
        list.add(getClassName(file.getPath()));
    }

    private String getClassName(String path){
        path = path.substring(baseDir.length());
        path = path.replace("\\",".");
        path = path.substring(0, path.lastIndexOf("."));
        return path;
    }
}
