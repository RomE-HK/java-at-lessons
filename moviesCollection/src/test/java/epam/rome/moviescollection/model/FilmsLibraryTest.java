package epam.rome.moviescollection.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilmsLibraryTest {

    private FilmsLibrary testCollection;
    private Film testFilm;
    private Actor testActor;

    @Before
    public void setUp() {
        testCollection = new FilmsLibrary();
        testFilm = new Film("Jeeves and Wooster", 1990);
        testActor = new Actor("Hugh", "Laurie" , 1959);

        testFilm.setGenre("Comedy");
        testFilm.addActor(testActor);
        testCollection.addFilm(testFilm);
    }

    @After
    public void cleanUp() {
        testCollection = null;
        testFilm = null;
        testActor = null;
    }

    @Test
    public void shouldNotAddNullFilmTest() {
        int sizeBefore = testCollection.getFilmCollection().size();
        testCollection.addFilm(null);
        assertEquals(sizeBefore, testCollection.getFilmCollection().size());
    }

    @Test
    public void shouldAddDefaultFilmTest() {
        Film newFilm = new Film("Interstate 60", 2002);
        testCollection.addFilm(newFilm);
        assertTrue(testCollection.getFilmCollection().contains(newFilm));
    }

    @Test
    public void shouldAddFilmProperlyTest() {
        Film newFilm = new Film("House M.D.", 2004);
        testCollection.addFilm(newFilm);
        assertTrue(testCollection.getFilmCollection().contains(newFilm));
    }

    @Test
    public void shouldNotGetFilmEmptyTest() {
        assertNull(testCollection.getFilm(null, 2000));
        assertNull(testCollection.getFilm("", 2000));
        assertNull(testCollection.getFilm("abc", 500));
        assertNull(testCollection.getFilm("abc", 2000));
    }

    @Test
    public void shouldNotGetFilmMissingTest() {
        assertNull(testCollection.getFilm("Jeeves and Wooster", 2000));
        assertNull(testCollection.getFilm("abc", 2000));
    }

    @Test
    public void shouldGetFilmProperlyTest() {
        assertEquals(testFilm, testCollection.getFilm("Jeeves and Wooster", 1990));
    }

    @Test
    public void shouldNotDeleteFilmNullTest() {
        assertFalse(testCollection.deleteFilm(null, 2000));
    }

    @Test
    public void shouldNotDeleteFilmMissingTest() {
        assertFalse(testCollection.deleteFilm("House M.D.", 2000));
    }

    @Test
    public void shouldDeleteFilmProperlyTest() {
        assertTrue(testCollection.deleteFilm("Jeeves and Wooster", 1990));
    }

    @Test
    public void allFilmsByActorTest() {
        Film newFilm = new Film("House M.D.", 2004);
        newFilm.addActor("Hugh", "Laurie", 1959);
        testCollection.addFilm(newFilm);

        Film anotherFilm = new Film("Pulp Fiction", 1994);
        anotherFilm.addActor("John", "Travolta", 1954);
        testCollection.addFilm(anotherFilm);

        int sizeOfOriginalCollection = testCollection.getFilmCollection().size();
        FilmsLibrary filteredCollection = testCollection.allFilmsByActor("Hugh", "Laurie");
        int sizeOfFilteredCollection = filteredCollection.getFilmCollection().size();

        assertNotEquals(sizeOfOriginalCollection, sizeOfFilteredCollection);
    }
}