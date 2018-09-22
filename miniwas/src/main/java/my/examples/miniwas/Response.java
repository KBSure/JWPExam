package my.examples.miniwas;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Response {
    private OutputStream out;
    private PrintWriter pw;

    private String contentType;
    private long contentLength;
    private int statusCode;
    private String statusMessage;

    public Response(OutputStream out, PrintWriter pw){
        this.out = out;
        this.pw = pw;

//        String body = "<h1>Hello world!</h1>";
//        pw.println("HTTP/1.1 200 OK");
//        pw.println("content-length: " + body.length());
//        pw.println("content-type: " + "text/html; charset=UTF-8");
//        pw.println();
//        pw.println(body);
//        pw.flush();
    }

    public OutputStream getOut() {
        return out;
    }

    public PrintWriter getPw() {
        return pw;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
