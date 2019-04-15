package epam.rome.stringio;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

import java.util.HashMap;
import java.util.Map;

import static epam.rome.stringio.StringIOFindKeyWords.*;
import static org.junit.Assert.*;

@RunWith(StringIOFindKeyWordsTest.class)
@Suite.SuiteClasses({ StringIOFindKeyWordsTest.testGetKeyWordsFromFile.class,
        StringIOFindKeyWordsTest.testFindMatchesInFile.class,
        StringIOFindKeyWordsTest.testWriteFile.class,
        StringIOFindKeyWordsTest.testPrintAllMap.class })
public class StringIOFindKeyWordsTest extends Suite {

    public StringIOFindKeyWordsTest(Class<?> classok, RunnerBuilder builder) throws InitializationError {
        super(classok, builder);
    }

    private static Map<String, Integer> testMap;
    private static String testClassFilePath;

    @BeforeClass
    public static void setUpClass() {
        testMap = new HashMap<>();
        testMap.put("goto", 0);
        testMap.put("void", 0);
    }

    @AfterClass
    public static void cleanUp() {
        testMap = null;
        testClassFilePath = null;
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
            testClassFilePath = "src/test/java/epam/rome/stringio/testing.txt";
            assertNotNull(getKeyWordsFromFile(testClassFilePath));
        }
    }

    public static class testFindMatchesInFile {
        @Before
        public void setUp() {
            testClassFilePath = "src/test/java/epam/rome/stringio/reading.class";
            testMap.put("goto", 0);
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
            assertFalse(findMatchesInFile(null, testClassFilePath));
            assertFalse(findMatchesInFile(new HashMap<>(), testClassFilePath));
        }

        @Test
        public void shouldNotCountGluedMatches() {
            String corruptedClassFilePath = "src/test/java/epam/rome/stringio/corrupted.class";
            findMatchesInFile(testMap, corruptedClassFilePath);
            assertEquals((int)testMap.get("void"), 1);
        }

        @Test
        public void shouldEqualsForGoodInput() {
            findMatchesInFile(testMap, testClassFilePath);
            assertEquals((int)testMap.get("void"), 8);
        }
    }

    public static class testWriteFile {
        @Before
        public void setUp() {
            testClassFilePath = "src/test/java/epam/rome/stringio/result.txt";
        }

        @Test
        public void shouldReturnFalseForEmptyMap() {
            assertFalse(writeFile(null, testClassFilePath));
            assertFalse(writeFile(new HashMap<>(), testClassFilePath));
        }

        @Test
        public void shouldReturnTrueForGoodInput() {
            assertTrue(writeFile(testMap, testClassFilePath));
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

