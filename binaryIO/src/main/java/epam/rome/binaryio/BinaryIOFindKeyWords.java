package epam.rome.binaryio;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryIOFindKeyWords {

    public static void readFile() {
        try (FileInputStream fis = new FileInputStream("str.java")) {
            int i;
            while ((i = fis.read()) != -1) {
                System.out.println((char)i);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void writeFile() {
        try(FileOutputStream fos=new FileOutputStream("str.java")) {
            String text = "Hello world!";
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
