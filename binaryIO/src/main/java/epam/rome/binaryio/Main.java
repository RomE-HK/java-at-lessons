package epam.rome.binaryio;

import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String keywordsFilePath = "binaryIO/src/main/java/epam/rome/binaryio/keywords.txt";
        BinaryIOFindKeyWords.pullKeyWords(keywordsFilePath);
        String readingFilePath = "binaryIO/src/main/java/epam/rome/binaryio/reading.class";
        BinaryIOFindKeyWords.readFile(readingFilePath);
        
        return;
    }
}
