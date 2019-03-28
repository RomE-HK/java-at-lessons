package epam.rome.moviescollection;

import epam.rome.moviescollection.model.Actor;
import epam.rome.moviescollection.model.Film;
import epam.rome.moviescollection.model.FilmsSet;


public class Main {

    public static void main(String[] args) {
        FilmsSet myCollection = new FilmsSet();

        Film firstFilm = new Film();
        firstFilm.setGenre("History");

        Actor firstActor = new Actor("Tim", "Roth");
        firstActor.setYearOfBorn(1865);
        Actor secondActor = new Actor("Grace", "Brown");
        secondActor.setYearOfBorn(1868);

        System.out.println(firstActor.toString());
        System.out.println(secondActor.toString());

        firstFilm.addActor(firstActor);
        firstFilm.addActor(secondActor);

        myCollection.addFilm(firstFilm);
        myCollection.showAllFilms();
    }
}
