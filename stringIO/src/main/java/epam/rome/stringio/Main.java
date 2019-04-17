package epam.rome.stringio;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String keywordsFilePath = "keywords.txt";
        String readingFilePath = "reading.class";
        String writingFilePath = "result.txt";

        Map<String, Integer> keywordsMap = StringIOFindKeyWords.getKeyWordsFromFile(keywordsFilePath);
        StringIOFindKeyWords.findMatchesInFile(keywordsMap, readingFilePath);
        StringIOFindKeyWords.writeFile(keywordsMap, writingFilePath);
        StringIOFindKeyWords.printAllMap(keywordsMap);

        return;
    }
}