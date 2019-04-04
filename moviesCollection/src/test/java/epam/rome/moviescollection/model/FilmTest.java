package epam.rome.moviescollection.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilmTest {

    private Film testFilm;
    private Actor testActor;

    @Before
    public void setUp() {
        testFilm = new Film("Jeeves and Wooster", 1990);
        testActor = new Actor("Hugh", "Laurie" , 1959);
        testFilm.addActor(testActor);
        testFilm.setGenre("Comedy");
    }

    @After
    public void cleanUp() {
        testFilm = null;
        testActor = null;
    }

    @Test
    public void shouldNotSetTitleEmptyTest() {
        String newTitle = "";
        testFilm.setTitle(newTitle);
        assertNotEquals(newTitle, testFilm.getTitle());
        testFilm.setTitle(null);
        assertNotEquals(null, testFilm.getTitle());
    }

    @Test
    public void shouldSetTitleProperlyTest() {
        String newTitle = "Pulp Fiction";
        testFilm.setTitle(newTitle);
        assertEquals(newTitle, testFilm.getTitle());
    }

    @Test
    public void shouldSetYearTooSmallTest() {
        int newYear = 666;
        testFilm.setYear(newYear);
        assertNotEquals(newYear, testFilm.getYear());
    }

    @Test
    public void shouldSetYearProperlyTest() {
        int newYear = 1994;
        testFilm.setYear(newYear);
        assertEquals(newYear, testFilm.getYear());
    }

    @Test
    public void shouldNotSetGenreEmptyTest() {
        String newGenre = "";
        testFilm.setGenre(newGenre);
        assertNotEquals(newGenre, testFilm.getGenre());
        testFilm.setGenre(null);
        assertNotEquals(null, testFilm.getGenre());
    }

    @Test
    public void shouldSetGenreProperlyTest() {
        String newGenre = "Crime";
        testFilm.setGenre(newGenre);
        assertEquals(newGenre, testFilm.getGenre());
    }

    @Test
    public void shouldNotAddNullActorTest() {
        int sizeBefore = testFilm.getFilmCast().size();
        testFilm.addActor(null);
        assertEquals(sizeBefore, testFilm.getFilmCast().size());
    }

    @Test
    public void shouldAddDefaultActorTest() {
        Actor newActor = new Actor();
        testFilm.addActor(newActor);
        assertTrue(testFilm.getFilmCast().contains(newActor));
    }

    @Test
    public void shouldAddActorProperlyTest() {
        Actor newActor = new Actor("Stephen", "Fry", 1957);
        testFilm.addActor(newActor);
        assertTrue(testFilm.getFilmCast().contains(newActor));
    }

    @Test
    public void shouldNotDeleteActorNullTest() {
        int sizeBefore = testFilm.getFilmCast().size();
        testFilm.deleteActor(null, null);
        assertEquals(sizeBefore, testFilm.getFilmCast().size());
    }

    @Test
    public void shouldNotDeleteActorMissingTest() {
        int sizeBefore = testFilm.getFilmCast().size();
        testFilm.deleteActor("Stephen", "Fry");
        assertEquals(sizeBefore, testFilm.getFilmCast().size());
    }

    @Test
    public void shouldDeleteActorProperlyTest() {
        int sizeBefore = testFilm.getFilmCast().size();
        testFilm.deleteActor("Hugh", "Laurie");
        assertEquals(sizeBefore - 1, testFilm.getFilmCast().size());
    }

    @Test
    public void compareToAnotherTitleTest() {
        Film newFilm = new Film("Shaun of the Dead", 2004);
        assertTrue( newFilm.compareTo(testFilm) > 0);

        newFilm = new Film("American Psycho", 2000);
        assertTrue( newFilm.compareTo(testFilm) < 0);
    }

    @Test
    public void compareToSameTitleButNewerTest() {
        Film newerFilm = new Film("Jeeves and Wooster", 1993);
        assertTrue( newerFilm.compareTo(testFilm) > 0);

        newerFilm = new Film("Jeeves and Wooster", 1989);
        assertTrue( newerFilm.compareTo(testFilm) < 0);
    }

    @Test
    public void compareToSameEverythingTest() {
        Film newestFilm = new Film("Jeeves and Wooster", 1990);
        assertTrue(newestFilm.compareTo(testFilm) == 0);
    }

    @Test
    public void filmCastToStringTest() {
        assertEquals("Hugh Laurie" + System.lineSeparator(), testFilm.filmCastToString());
    }

    @Test
    public void toStringTest() {
        StringBuilder builder = new StringBuilder();
        builder.append("Jeeves and Wooster, 1990" + System.lineSeparator());
        builder.append("Comedy" + System.lineSeparator());
        builder.append("Hugh Laurie" + System.lineSeparator() + System.lineSeparator());
        assertEquals(builder.toString(), testFilm.toString());
    }
}