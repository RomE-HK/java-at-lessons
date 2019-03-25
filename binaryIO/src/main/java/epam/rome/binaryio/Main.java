package epam.rome.binaryio;

import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> keywordsAmout = new HashMap<String, Integer>();
        BinaryIOFindKeyWords.writeFile();
        BinaryIOFindKeyWords.readFile();
        keywordsAmout = BinaryIOFindKeyWords.pullKeyWords();
        return;
    }
}
