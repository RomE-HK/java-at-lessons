package epam.rome.moviescollection.model;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;


public class Film implements Serializable {
    private String title;
    private int year;
    private String genre;
    private Map<String, Actor> roles = new HashMap<String, Actor>();

    private enum Genre {
        History, SciFi, Fantasy, Comedy, Drama, Romantic, Action, Thriller, Horror
    }

    public Film() {
        this("La voltige", 1895);
    }

    public Film(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void addRoleAndActor(String role, Actor actor) {
        roles.put(role, actor);
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
        for (Map.Entry<String, Actor> entry : roles.entrySet()) {
            System.out.print(entry.getKey() + " by " +  entry.getValue().getFullName());
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        return builder.toString();
    }
}
