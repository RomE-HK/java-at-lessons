package epam.rome.moviescollection;

import epam.rome.moviescollection.model.FilmsSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static epam.rome.moviescollection.Main.serializeCollection;
import static epam.rome.moviescollection.Main.deserializeCollection;
import static org.junit.Assert.*;

public class MainTest {
    private FilmsSet testCollection;
    private String filename;

    @Before
    public void setUp() {
        testCollection = new FilmsSet();
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