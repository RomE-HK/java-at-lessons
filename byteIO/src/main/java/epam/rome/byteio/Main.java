package epam.rome.byteio;

import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String keywordsFilePath = "byteIO/src/main/java/epam/rome/byteio/keywords.txt";
        ByteIOFindKeyWords.pullKeyWords(keywordsFilePath);
        String readingFilePath = "byteIO/src/main/java/epam/rome/byteio/reading.class";
        ByteIOFindKeyWords.readFile(readingFilePath);
        
        return;
    }
}
