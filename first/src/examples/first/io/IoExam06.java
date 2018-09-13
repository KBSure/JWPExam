package examples.first.io;

import java.io.*;

public class IoExam06 {
    public static void main(String[] args) {
        DataInputStream in = null;
        DataOutputStream out = null;
        try{
            out = new DataOutputStream(new FileOutputStream("c:\\users\\story\\a\\b\\c\\data.text"));
            out.writeBoolean(true);
            out.writeInt(13);
            out.writeDouble(50.3);
            out.writeUTF("Hi!");

            in = new DataInputStream(new FileInputStream("c:\\users\\story\\a\\b\\c\\data.text"));
            System.out.println(in.readBoolean());
            System.out.println(in.readInt());
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
