package epam.rome.stringio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.LinkedHashMap;


public class StringIOFindKeyWords {

    public static Map<String, Integer> getKeyWordsFromFile(String filePath) {
        if (!isFilePathExist(filePath)) {
            return null;
        }

        Map<String, Integer> map = new LinkedHashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String fileLine;
            while ((fileLine = br.readLine()) != null) {
                map.put(fileLine, 0);
            }
            System.out.println("Keywords successfully got");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return map;
    }

    public static boolean findMatchesInFile(Map<String, Integer> map, String filePath) {
        if (!checkArguments(map, filePath)) {
            return false;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String fileLine;
            while ((fileLine = br.readLine()) != null) {
                findMatchesInString(map, fileLine);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        System.out.println("Matches successfully found");
        return true;
    }

    public static boolean writeFile(Map<String, Integer> map, String filePath) {
        if (isStringEmpty(filePath) || isMapEmpty(map)) {
            return false;
        }

        try (FileWriter fos = new FileWriter(filePath)) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() != 0) {
                    String line = entry.getKey() + " : " + entry.getValue() + System.lineSeparator();
                    fos.write(line);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        System.out.println("Matches successfully wrote to file");
        return true;
    }

    public static boolean printAllMap(Map<String, Integer> map) {
        if (isMapEmpty(map)) {
            return false;
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " : " + entry.getValue() + System.lineSeparator());
        }
        return true;
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

    private static boolean isMapEmpty(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            System.out.println("The keywords map is empty or null");
            return true;
        }
        return false;
    }

    private static boolean isFilePathExist(String value) {
        if (!isStringEmpty(value) && Files.exists(Paths.get(value))) {
            return true;
        }
        System.out.println("Wrong filepath");
        return false;
    }

    private static boolean checkArguments(Map<String, Integer> map, String filePath) {
        if (!isFilePathExist(filePath)) {
            return false;
        } else if (isMapEmpty(map)) {
            return false;
        }
        return true;
    }
}
