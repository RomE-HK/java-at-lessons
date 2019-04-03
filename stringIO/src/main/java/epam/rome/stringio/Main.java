package epam.rome.stringio;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String keywordsFilePath = "src/main/java/epam/rome/stringio/keywords.txt";
        String readingFilePath = "src/main/java/epam/rome/stringio/reading.class";
        String writingFilePath = "src/main/java/epam/rome/stringio/result.txt";

        Map<String, Integer> keywordsMap = StringIOFindKeyWords.getKeyWordsFromFile(keywordsFilePath);
        StringIOFindKeyWords.findMatchesInFile(keywordsMap, readingFilePath);
        StringIOFindKeyWords.writeFile(keywordsMap, writingFilePath);
        StringIOFindKeyWords.printAllMap(keywordsMap);

        return;
    }
}