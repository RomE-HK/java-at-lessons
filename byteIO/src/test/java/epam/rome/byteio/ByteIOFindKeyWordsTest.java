package epam.rome.byteio;

import org.junit.Test;

import static org.junit.Assert.*;

public class ByteIOFindKeyWordsTest {

    @Test
    public void getKeyWordsFromFile() {
        ByteIOFindKeyWords.getKeyWordsFromFile("");
        ByteIOFindKeyWords.getKeyWordsFromFile("wrong/path");
        ByteIOFindKeyWords.getKeyWordsFromFile("src/main/java/epam/rome/byteio/empty.txt");
    }

    @Test
    public void findMatchesInFile() {
    }

    @Test
    public void writeFile() {
    }

    @Test
    public void printAllMap() {
    }
}