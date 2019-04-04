package epam.rome.moviescollection.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActorTest {

    Actor testActor;

    @Before
    public void setUp() {
        testActor = new Actor();
    }

    @After
    public void cleanUp() {
        testActor = null;
    }

    @Test
    public void shouldNotSetNameEmptyTest() {
        String newName = "";
        testActor.setName(newName);
        assertNotEquals(newName, testActor.getName());
        testActor.setName(null);
        assertNotEquals(null, testActor.getName());
    }

    @Test
    public void shouldSetNameProperlyTest() {
        String newName = "Hugh";
        testActor.setName(newName);
        assertEquals(newName, testActor.getName());
    }

    @Test
    public void shouldNotSetSurnameEmptyTest() {
        String newSurname = "";
        testActor.setSurname(newSurname);
        assertNotEquals(newSurname, testActor.getSurname());
        testActor.setSurname(null);
        assertNotEquals(null, testActor.getSurname());
    }

    @Test
    public void shouldSetSurnameProperlyTest() {
        String newActor = "Laurie";
        testActor.setSurname(newActor);
        assertEquals(newActor, testActor.getSurname());
    }

    @Test
    public void shouldNotSetYearOfBornTooOldTest() {
        int newYearOfBorn = 777;
        testActor.setYearOfBorn(newYearOfBorn);
        assertNotEquals(newYearOfBorn, testActor.getYearOfBorn());
    }

    @Test
    public void shouldSetYearOfBornProperlyTest() {
        int newYearOfBorn = 1959;
        testActor.setYearOfBorn(newYearOfBorn);
        assertEquals(newYearOfBorn, testActor.getYearOfBorn());
    }

    @Test
    public void toStringTest() {
        Actor testActor = new Actor("Hugh", "Laurie", 1959);
        assertEquals("Hugh Laurie"  + System.lineSeparator() + "Age of 60, 1959", testActor.toString());
    }
}