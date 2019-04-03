package epam.rome.moviescollection.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ActorTest {

    @Test
    public void toStringShould() {
        Actor testActor = new Actor("Hugh", "Laurie", 1959);
        assertEquals("Hugh Laurie"  + System.lineSeparator() + "Age of 60, 1959", testActor.toString());
    }
}