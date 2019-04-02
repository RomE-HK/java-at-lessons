package epam.rome.byteio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(ByteIOFindKeyWordsTest.class)
@Suite.SuiteClasses({ ByteIOFindKeyWordsTest.testGetKeyWordsFromFile.class, ByteIOFindKeyWordsTest.testFindMatchesInFile.class })
public class ByteIOFindKeyWordsTest extends Suite {

    public ByteIOFindKeyWordsTest(Class<?> klass, RunnerBuilder builder) throws InitializationError {
        super(klass, builder);
    }

    public static class testGetKeyWordsFromFile {
        @Test
        public void shouldReturnNullForBadFilePath() {
            assertNull(ByteIOFindKeyWords.getKeyWordsFromFile(null));
            assertNull(ByteIOFindKeyWords.getKeyWordsFromFile(""));
            assertNull(ByteIOFindKeyWords.getKeyWordsFromFile("wrong/path"));
        }

        @Test
        public void shouldReturnNotNullForGoodFilePath() {
            assertNotNull(ByteIOFindKeyWords.getKeyWordsFromFile("src/main/java/epam/rome/byteio/keywords.txt"));
        }
    }

    public static class testFindMatchesInFile {

        private Map<String, Integer> testMap;
        private String testFilePath;

        @Before
        public void setUp() {
            testFilePath  = "src/main/java/epam/rome/byteio/reading.class";
        }

        @After
        public void cleanUp() {
            testFilePath = "";
        }

        @Test
        public void shouldReturnFalseForBadFilePath() {
            assertFalse(ByteIOFindKeyWords.findMatchesInFile(testMap, null));
            assertFalse(ByteIOFindKeyWords.findMatchesInFile(testMap, ""));
            assertFalse(ByteIOFindKeyWords.findMatchesInFile(testMap, "wrong/path"));
        }

        @Test
        public void shouldReturnFalseForNullMap() {
            assertFalse(ByteIOFindKeyWords.findMatchesInFile(null, testFilePath));
        }

        @Test
        public void shouldReturnFalseForEmptyMap() {
            assertFalse(ByteIOFindKeyWords.findMatchesInFile(new HashMap<>(), testFilePath));
        }

        @Test
        public void writeFile() {
        }

        @Test
        public void printAllMap() {
        }

    }



}

