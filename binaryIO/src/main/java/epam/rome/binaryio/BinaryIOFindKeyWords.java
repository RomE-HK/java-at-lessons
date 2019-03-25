package epam.rome.binaryio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.HashMap;

public class BinaryIOFindKeyWords {

    public static void readFile() {
        String filePath = "binaryIO/src/main/java/epam/rome/binaryio/reading.class";
        try (FileInputStream fis = new FileInputStream(filePath)) {
            int i;
            while ((i = fis.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void writeFile() {
        String filePath = "binaryIO/src/main/java/epam/rome/binaryio/str.java";
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            String text = "Hello world!";
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Map<String, Integer> pullKeyWords() {
        String filePath = "binaryIO/src/main/java/epam/rome/binaryio/keywords.txt";
        Map<String, Integer> map = new HashMap<String, Integer>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                map.put(strLine, 0);
                System.out.println(strLine);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return map;
    }
}
