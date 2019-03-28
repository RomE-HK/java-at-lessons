package epam.rome.moviescollection.model;

import java.io.Serializable;
import java.util.ArrayList;


public class Film implements Serializable, Comparable<Film> {
    private String title;
    private int year;
    private String genre;
    private ArrayList<Actor> cast = new ArrayList<>();

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

    public void addActor(Actor actor) {
        cast.add(actor);
    }

    public Actor getActor(String surname) {
        for (Actor actor : cast) {
            if (actor.getFullName().contains(surname)) {
                return actor;
            }
        }
        return null;
    }

    public void deleteActor(String surname) {
        for (Actor actor : cast) {
            if (actor.getFullName().contains(surname)) {
                cast.remove(actor);
            }
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

    public void showCast() {
        for (Actor actor : cast) {
            System.out.println(actor.getFullName());
        }
    }

    public int compareTo(Film film){
        return title.compareTo(film.getTitle());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(System.lineSeparator() + title + ", " + year + System.lineSeparator());
        builder.append(genre + System.lineSeparator());
        for (Actor actor : cast) {
            builder.append(actor.getFullName() + System.lineSeparator());
        } /// В принципе то же самое что showCast, надо обдумать
        return builder.toString();
    }
}

