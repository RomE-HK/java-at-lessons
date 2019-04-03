package epam.rome.moviescollection.model;

import java.io.Serializable;
import java.util.ArrayList;


public class Film implements Serializable, Comparable<Film> {
    private String title;
    private int year;
    private String genre;
    private ArrayList<Actor> filmCast = new ArrayList<>();

    public Film() {
        this("La voltige", 1895);
    }

    public Film(String title, int year) {
        setTitle(title);
        setYear(year);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void addActor(Actor newActor) {
        if (newActor != null) {
            filmCast.add(newActor);
        } else {
        System.out.println("The object of Actor cannot be null");
        }
    }

    public void addActor(String name, String surname, int yearOfBorn) {
        Actor newActor = new Actor(name, surname, yearOfBorn);
        addActor(newActor);
    }

    public void deleteActor(String name, String surname) {
        int deletingActor = Integer.MIN_VALUE;
        for (Actor actor : filmCast) {
            if (actor.getFullName().contains(name) && actor.getFullName().contains(surname)) {
                deletingActor = filmCast.indexOf(actor);
                break;
            }
        }
        if (deletingActor != Integer.MIN_VALUE) {
            filmCast.remove(deletingActor);
        }
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

    public ArrayList<Actor> getFilmCast() {
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
            return  year - film.getYear();
        }
        return title.compareTo(film.getTitle());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getTitle() + ", " + getYear() + System.lineSeparator());
        builder.append(getGenre() + System.lineSeparator());
        builder.append(filmCastToString() + System.lineSeparator());
        return builder.toString();
    }
}

