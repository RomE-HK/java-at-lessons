package epam.rome.byteio;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

import java.util.HashMap;
import java.util.Map;

import static epam.rome.byteio.ByteIOFindKeyWords.*;
import static org.junit.Assert.*;

@RunWith(ByteIOFindKeyWordsTest.class)
@Suite.SuiteClasses({ ByteIOFindKeyWordsTest.testGetKeyWordsFromFile.class,
        ByteIOFindKeyWordsTest.testFindMatchesInFile.class,
        ByteIOFindKeyWordsTest.testWriteFile.class,
        ByteIOFindKeyWordsTest.testPrintAllMap.class })
public class ByteIOFindKeyWordsTest extends Suite {

    public ByteIOFindKeyWordsTest(Class<?> classok, RunnerBuilder builder) throws InitializationError {
        super(classok, builder);
    }

    private static Map<String, Integer> testMap;
    private static String testFilePath;

    @BeforeClass
    public static void setUpClass() {
        testMap = new HashMap<>();
    }

    @AfterClass
    public static void cleanUp() {
        testMap = null;
        testFilePath = null;
    }

    public static class testGetKeyWordsFromFile {
        @Test
        public void shouldReturnNullForBadFilePath() {
            assertNull(getKeyWordsFromFile(null));
            assertNull(getKeyWordsFromFile(""));
            assertNull(getKeyWordsFromFile("wrong/path"));
        }

        @Test
        public void shouldReturnNotNullForGoodFilePath() {
            testFilePath = "test_keywords.txt";
            assertNotNull(getKeyWordsFromFile(testFilePath));
        }
    }

    public static class testFindMatchesInFile {
        @Before
        public void setUp() {
            testFilePath = "reading.class";
            testMap.put("break", 0);
            testMap.put("continue", 0);
            testMap.put("else", 0);
            testMap.put("void", 0);
        }

        @Test
        public void shouldReturnFalseForBadFilePath() {
            assertFalse(findMatchesInFile(testMap, null));
            assertFalse(findMatchesInFile(testMap, ""));
            assertFalse(findMatchesInFile(testMap, "wrong/path"));
        }

        @Test
        public void shouldReturnFalseForEmptyMap() {
            assertFalse(findMatchesInFile(null, testFilePath));
            assertFalse(findMatchesInFile(new HashMap<>(), testFilePath));
        }

        @Test
        public void shouldReturnTrueForWordsWithPunctuationMarks() {
            findMatchesInFile(testMap, testFilePath);
            assertTrue(testMap.get("break") != 0);
            assertTrue(testMap.get("continue") != 0);
        }

        @Test
        public void shouldReturnTrueForGoodInput() {
            findMatchesInFile(testMap, testFilePath);
            assertTrue(testMap.get("void") != 0);
        }
    }

    public static class testWriteFile {
        @Before
        public void setUp() {
            testFilePath = "test_result.txt";
        }

        @Test
        public void shouldReturnFalseForEmptyMap() {
            assertFalse(writeFile(null, testFilePath));
            assertFalse(writeFile(new HashMap<>(), testFilePath));
        }

        @Test
        public void shouldReturnTrueForGoodInput() {
            testMap.put("break", 1);
            assertTrue(writeFile(testMap, testFilePath));
        }
    }

    public static class testPrintAllMap {
        @Test
        public void shouldReturnFalseForEmptyMap() {
            assertFalse(printAllMap(null));
            assertFalse(printAllMap(new HashMap<>()));
        }

        @Test
        public void shouldReturnTrueForGoodMap() {
            assertTrue(printAllMap(testMap));
        }
    }
}

