package epam.rome.byteio;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String keywordsFilePath = "keywords.txt";
        String readingFilePath = "reading.class";
        String writingFilePath = "result.txt";

        Map<String, Integer> keywordsMap = ByteIOFindKeyWords.getKeyWordsFromFile(keywordsFilePath);
        ByteIOFindKeyWords.findMatchesInFile(keywordsMap, readingFilePath);
        ByteIOFindKeyWords.writeFile(keywordsMap, writingFilePath);
        ByteIOFindKeyWords.printAllMap(keywordsMap);

        return;
    }
}
