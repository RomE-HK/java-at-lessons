package epam.rome.moviescollection.model;

import org.junit.Test;

import static epam.rome.moviescollection.model.Tools.*;
import static org.junit.Assert.*;

public class ToolsTest {

    private String noneEmptyString = "testing";
    private String justEmptyString = "";
    private int tooSmallYear = 1000;
    private int minimumCorrectYear = Film.DEFAULT_YEAR;
    private int correctYear = 2015;

    @Test
    public void isStringEmptyTest() {
        assertFalse(isStringEmpty(noneEmptyString));
        assertTrue(isStringEmpty(justEmptyString));
        assertTrue(isStringEmpty(null));
    }

    @Test
    public void isFilmYearTooSmallTest() {
        assertTrue(isFilmYearTooSmall(tooSmallYear));
        assertFalse(isFilmYearTooSmall(minimumCorrectYear));
        assertFalse(isFilmYearTooSmall(correctYear));
    }
}