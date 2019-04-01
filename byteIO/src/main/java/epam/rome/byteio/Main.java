package epam.rome.byteio;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String keywordsFilePath = "src/main/java/epam/rome/byteio/keywords.txt";
        String readingFilePath = "src/main/java/epam/rome/byteio/reading.class";
        String writingFilePath = "src/main/java/epam/rome/byteio/result.txt";

        Map<String, Integer> keywordsMap = ByteIOFindKeyWords.getKeyWordsFromFile(keywordsFilePath);
        ByteIOFindKeyWords.findMatchesInFile(keywordsMap, readingFilePath);
        ByteIOFindKeyWords.writeFile(keywordsMap, writingFilePath);
        ByteIOFindKeyWords.printAllMap(keywordsMap);

        return;
    }
}
