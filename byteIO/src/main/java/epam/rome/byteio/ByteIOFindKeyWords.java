package epam.rome.byteio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.LinkedHashMap;

public class ByteIOFindKeyWords {

    public static Map<String, Integer> getKeyWordsFromFile(String filePath) {
        if (!isFilePathExist(filePath)) {
            return null;
        }
        
        Map<String, Integer> map = new LinkedHashMap<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String fileLine;
            while ((fileLine = br.readLine()) != null) {
                map.put(fileLine, 0);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Keywords successfully got");
        return map;
    }

    public static boolean findMatchesInFile(Map<String, Integer> map, String filePath) {
        if (!isFilePathExist(filePath)) {
            return false;
        }
        if (map == null || map.isEmpty()) {
            System.out.println("The map is empty or null");
            return false;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String fileLine;
            while ((fileLine = br.readLine()) != null) {
                findMatchesInString(map, fileLine);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Matches successfully found");
        return true;
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

    private static void findMatchesInString(Map<String, Integer> map, String str) {
        String[] words = str.split(" ");
        for (String subStr : words) {
            if (map.containsKey(subStr)) {
                map.put(subStr, map.get(subStr) + 1);
            }
        }
    }

    private static boolean isStringEmpty(String value){
        return value == null || "".equals(value.trim());
    }

    private static boolean isFilePathExist(String value) {
        if (isStringEmpty(value) || !Files.exists(Paths.get(value))) {
            System.out.println("Wrong filepath");
            return false;
        }
        return true;
    }
}
