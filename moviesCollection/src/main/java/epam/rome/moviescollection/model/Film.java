package epam.rome.moviescollection.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static epam.rome.moviescollection.model.Tools.*;


public class Film implements Serializable, Comparable<Film> {
    private String title;
    private int year;
    private String genre;
    private List<Actor> filmCast;

    public static final String DEFAULT_TITLE = "Roundhay Garden Scene";
    public static final int DEFAULT_YEAR = 1888;

    public Film() {
        this(DEFAULT_TITLE, DEFAULT_YEAR);
    }

    public Film(String title, int year) {
        setTitle(title);
        setYear(year);
        filmCast = new ArrayList<>();
    }

    public void setTitle(String title) {
        if (isStringEmpty(title)) {
            System.out.println("Title was set to default because of empty string");
            this.title = DEFAULT_TITLE;
            return;
        }
        this.title = title;
    }

    public void setYear(int year) {
        if (isFilmYearTooSmall(year)) {
            System.out.println("Year was set to default, cause it's a year of earliest surviving motion-picture film");
            this.year = DEFAULT_YEAR;
            return;
        }
        this.year = year;
    }

    public void setGenre(String genre) {
        if (isStringEmpty(genre)) {
            System.out.println("Cannot set the empty genre");
            return;
        }
        this.genre = genre;
    }

    public void addActor(Actor newActor) {
        if (newActor == null) {
            System.out.println("The object of Actor cannot be null");
            return;
        }
        filmCast.add(newActor);
    }

    public void addActor(String name, String surname, int yearOfBorn) {
        /* if (isNameSurnameEmpty(name, surname)) {
            System.out.println("Actor wasn't added!");
            return;     //ВОПРОС: ЕЩЁ ПРОВЕРКА НУЖНА, ВЕДЬ ПРИ СОЗДАНИИ АКТЁРА ОНА ПРОИСХОДИТ И ТАК?
        } */
        addActor(new Actor(name, surname, yearOfBorn));
    }

    public Actor getActor(String searchName, String searchSurname) {
        if (!isNameSurnameEmpty(searchName, searchSurname)) {
            for (Actor actor : filmCast) {
                if (actor.getFullName().contains(searchName) && actor.getFullName().contains(searchSurname)) {
                    return actor;
                }
            }
        }
        System.out.println("There is no match for such actor. Null returned!");
        return null;
    }

    public void deleteActor(String name, String surname) {
        if (isNameSurnameEmpty(name, surname)) {
            System.out.println("There is no match for this title and year");
            return;
        }
        Actor foundActor = getActor(name, surname);
        if (foundActor == null) {
            System.out.println("Actor wasn't deleted!");
            return;
        }
        filmCast.remove(foundActor);
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public List<Actor> getFilmCast() {
        return filmCast;
    }

    public String filmCastToString() {
        StringBuilder builder = new StringBuilder();
        for (Actor actor : filmCast) {
            builder.append(actor.getFullName() + System.lineSeparator());
        }
        return builder.toString();
    }

    public int compareTo(Film film){
        if (title.equals(film.getTitle())) {
            return year - film.getYear();
        }
        return title.compareTo(film.getTitle());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getTitle() + ", " + getYear() + System.lineSeparator());
        builder.append(getGenre() + System.lineSeparator());
        //builder.append(filmCastToString() + System.lineSeparator());
        return builder.toString();
    }


}

