package epam.rome.moviescollection;

import epam.rome.moviescollection.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static epam.rome.moviescollection.Main.serializeCollection;
import static epam.rome.moviescollection.Main.deserializeCollection;
import static org.junit.Assert.*;

public class MainTest {
    private FilmsLibrary testCollection;
    private String testFilename;

    @Before
    public void setUp() {
        new File(testFilename + ".dat").delete();
        testCollection = new FilmsLibrary();
        testFilename = "serialized_collection";
    }

    @After
    public void cleanUp() {
        new File(testFilename + ".dat").delete();
        testCollection = null;
        testFilename = null;
    }

    @Test
    public void shouldSerializeCollectionNullTest() {
        assertFalse(new File(testFilename + ".dat").exists());
        serializeCollection(null, testFilename);
        assertTrue(new File(testFilename + ".dat").exists());
        return;
    }

    @Test
    public void shouldSerializeCollectionProperlyTest() {
        assertFalse(new File(testFilename + ".dat").exists());
        serializeCollection(testCollection, testFilename);
        assertTrue(new File(testFilename + ".dat").exists());
    }

    @Test
    public void shouldDeserializeCollectionNullTest() {
        serializeCollection(null, testFilename);
        assertNull(deserializeCollection(testFilename));
    }

    @Test
    public void shouldDeserializeCollectionEmptyTest() {
        serializeCollection(new FilmsLibrary(), testFilename);
        assertNotNull(deserializeCollection(testFilename));
    }

    @Test
    public void shouldDeserializeCollectionProperlyTest() {
        String movieTitle = "The Last Boy Scout";
        int movieYear = 1991;
        String actorName = "Bruce";
        String actorSurname = "Willis";

        Film movie = new Film(movieTitle, movieYear);
        movie.addActor(new Actor(actorName, actorSurname, 1955));
        testCollection.addFilm(movie);
        serializeCollection(testCollection, testFilename);

        FilmsLibrary deserializedCollection = deserializeCollection(testFilename);
        assertTrue(deserializedCollection.getFilm(movieTitle, movieYear).deleteActor(actorName, actorSurname));
        assertTrue(deserializedCollection.deleteFilm(movieTitle, movieYear));
    }
}