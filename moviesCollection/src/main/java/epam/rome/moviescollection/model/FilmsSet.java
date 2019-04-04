package epam.rome.moviescollection.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static epam.rome.moviescollection.model.Film.isFilmYearTooSmall;
import static epam.rome.moviescollection.model.Tools.*;

public class FilmsSet implements Serializable {
    private Set<Film> allFilms;

    public FilmsSet() {
        allFilms = new TreeSet<>();
    }

    public void addFilm(Film newFilm) {
        if (newFilm == null) {
            System.out.println("The object of Film cannot be null");
            return;
        }
        allFilms.add(newFilm);
    }

    public void addFilm(String title, int year) {
        if (!isTitleAndYearCorrect(title, year)) {
            System.out.println("Film wasn't added!");
            return;
        }
        addFilm(new Film(title, year));
    }

    public Film getFilm(String searchTitle, int searchYear) {
        for (Film film : allFilms) {
            if (film.getTitle().equals(searchTitle) && film.getYear() == searchYear) {
                return film;
            }
        }
        return null;
    }

    public void deleteFilm(String searchTitle, int searchYear) {
        for (Film film : allFilms) {
            if (film.getTitle().equals(searchTitle) && film.getYear() == searchYear) {
                allFilms.remove(film);
            }
        }
    }

    public void editFilm(String title, int year, String genre) {  // ШТА???
        Film film = getFilm(title, year); // ШТА???
        System.out.println(getFilm(title, year).toString());
        film.setTitle(title);  // ШТА???
        film.setYear(year);
        film.setGenre(genre);
    }

    public List<Film> allFilmsByActor(String searchName, String searchSurname) {
        List<Film> playInFilms = new ArrayList<>();
        for (Film film : allFilms) {
            List<Actor> actorsOfFilm = film.getFilmCast();
            for (Actor actor : actorsOfFilm) {
                String name = actor.getName();
                String surname = actor.getSurname();
                if (surname.equals(searchSurname) && name.equals(searchName)) {
                    playInFilms.add(film);
                }
                break;
            }
        }
        return playInFilms;
    }

    public void showFilmsByActor(String name, String surname) {
        for (Film film : allFilmsByActor(name, surname)) {
            System.out.println(film.toString());
        }
    }

    public void showAllFilms() {
        for (Film film : allFilms) {
            System.out.println(film.toString());
        }
    }

    private boolean isTitleAndYearCorrect(String title, int year) {
        if (isStringEmpty(title)) {
            System.out.println("Title cannot be empty");
            return false;
        } else if (isFilmYearTooSmall(year)) {
            System.out.println("Film year too small");
            return false;
        }
        return true;
    }
}
