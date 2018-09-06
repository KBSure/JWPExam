package examples.first.instancetest;

public class StringBufferTest {
    /**
     * StringBufferTest Main
     * @param args
     */
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append(" ");
        sb.append("world!!!");

        System.out.println(sb.toString());
    }
}
