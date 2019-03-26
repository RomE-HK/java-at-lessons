package epam.rome.byteio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.LinkedHashMap;

public class ByteIOFindKeyWords {

    public static Map<String, Integer> getKeyWordsFromFile(String filePath) {
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String fileLine;
            while ((fileLine = br.readLine()) != null) {
                map.put(fileLine, 0);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return map;
    }

    public static void readFile(Map<String, Integer> map, String filePath) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String fileLine;
            while ((fileLine = br.readLine()) != null) {
                findMathesInString(map, fileLine);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void writeFile(Map<String, Integer> map, String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() != 0) {
                    String line = entry.getKey() + " : " + entry.getValue() + System.lineSeparator();
                    byte[] buffer = line.getBytes();
                    fos.write(buffer);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printAllMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " : " + entry.getValue() + System.lineSeparator());
        }
    }

    private static void findMathesInString(Map<String, Integer> map, String str) {
        String[] words = str.split(" ");
        for (String subStr : words) {
            if (map.containsKey(subStr)) {
                map.put(subStr, map.get(subStr) + 1);
            }
        }
    }
}
