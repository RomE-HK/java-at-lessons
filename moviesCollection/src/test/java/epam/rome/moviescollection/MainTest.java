package epam.rome.moviescollection;

import epam.rome.moviescollection.model.FilmsLibrary;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
    private FilmsLibrary testCollection;
    private String filename;

    @Before
    public void setUp() {
        testCollection = new FilmsLibrary();
    }

    @After
    public void cleanUp() {
        testCollection = null;
    }

    @Test
    public void serializeCollection() {

    }

    @Test
    public void deserializeCollection() {
    }
}