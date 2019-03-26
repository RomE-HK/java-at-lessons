package epam.rome.byteio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.HashMap;

public class ByteIOFindKeyWords {

    private static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                findMathes(map, strLine);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
        return;
    }

    public static void writeFile() {
        String filePath = "byteIO/src/main/java/epam/rome/byteio/str.java";
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            String text = "Hello world!";
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void /*Map<String, Integer>*/ pullKeyWords(String filePath) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                map.put(strLine, 0);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // return map;
    }

    public static void findMathes(Map<String, Integer> map, String str) {
        String[] words = str.split(" ");
        for (String subStr : words) {
            if (map.containsKey(subStr)) {
                map.put(subStr, map.get(subStr) + 1);
            }
        }
    }
}
