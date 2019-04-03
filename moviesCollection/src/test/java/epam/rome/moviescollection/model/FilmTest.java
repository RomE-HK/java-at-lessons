package epam.rome.moviescollection.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilmTest {

    private Film testFilm;

    @Before
    public void setUp() {
        testFilm = new Film("Jeeves and Wooster", 1990);
        testFilm.addActor("Hugh", "Laurie" , 1959);
        testFilm.setGenre("Comedy");
    }

    @After
    public void cleanUp() {
        testFilm = null;
    }

    @Test
    public void addNullActorTest() {
        int sizeBeforeAdding = testFilm.getFilmCast().size();
        testFilm.addActor(null);
        assertEquals(sizeBeforeAdding, testFilm.getFilmCast().size());
    }

    @Test
    public void addEmptyActorTest() {
        int sizeBeforeAdding = testFilm.getFilmCast().size();
        testFilm.addActor(new Actor());
        assertEquals(sizeBeforeAdding + 1, testFilm.getFilmCast().size());
    }

    @Test
    public void deleteActorTest() {
        int sizeBeforeDeleting = testFilm.getFilmCast().size();
        testFilm.deleteActor("Hugh", "Laurie");
        assertEquals(sizeBeforeDeleting - 1, testFilm.getFilmCast().size());
    }

    @Test
    public void filmCastToStringTest() {
        assertEquals("Hugh Laurie" + System.lineSeparator(), testFilm.filmCastToString());
    }

    @Test
    public void compareToSameTitleTest() {
        Film newerFilm = new Film("Jeeves and Wooster", 1993);
        assertTrue( newerFilm.compareTo(testFilm) > 0);
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