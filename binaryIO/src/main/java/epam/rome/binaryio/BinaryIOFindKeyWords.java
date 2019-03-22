package epam.rome.binaryio;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public static void pullKeyWords() {
        try{
            FileInputStream fstream = new FileInputStream("keywords.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
               System.out.println(strLine);
            }
            br.close();
         }catch (IOException ex){
            System.out.println(ex.getMessage());
         }
    }
}
