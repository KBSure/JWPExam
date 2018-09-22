package my.examples.miniwas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Request {
    InputStream in;
    BufferedReader br;
    String method;
    String path;
    Map<String, String> headers;

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Request(InputStream in, BufferedReader br){
        this.in = in;
        this.br = br;
        this.headers = new HashMap<String, String>();

        String requestLine = null;
        String line = null;
        try {
            requestLine = br.readLine();
//            System.out.println(requestLine);
            String[] split = requestLine.split(" ");
            this.method = split[0];
            this.path = split[1];

            while((line = br.readLine()) != null){
                if ("".equals(line)) {
                    break;
                }
                int index1 = line.indexOf(":");
                if(index1 != -1){
                    String key = line.substring(0, index1).trim();
                    String value = line.substring(index1 + 1).trim();
                    headers.put(key, value);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("잘못된 요청 " + e.toString());
        }
    }
}
