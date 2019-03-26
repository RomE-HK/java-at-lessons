package epam.rome.byteio;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String keywordsFilePath = "byteIO/src/main/java/epam/rome/byteio/keywords.txt";
        String readingFilePath = "byteIO/src/main/java/epam/rome/byteio/reading.class";
        String writingFilePath = "byteIO/src/main/java/epam/rome/byteio/result.txt";

        Map<String, Integer> keywordsMap = ByteIOFindKeyWords.getKeyWordsFromFile(keywordsFilePath);
        ByteIOFindKeyWords.readFile(keywordsMap, readingFilePath);
        ByteIOFindKeyWords.writeFile(keywordsMap, writingFilePath);
        ByteIOFindKeyWords.printAllMap(keywordsMap);

        return;
    }
}
