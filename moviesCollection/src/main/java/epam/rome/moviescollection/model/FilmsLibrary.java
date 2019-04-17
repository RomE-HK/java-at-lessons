package epam.rome.moviescollection.model;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import static epam.rome.moviescollection.model.Tools.*;

public class FilmsLibrary implements Serializable {
    private Set<Film> allFilms;

    public FilmsLibrary() {
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
        addFilm(new Film(title, year));
    }

    public Film getFilm(String searchTitle, int searchYear) {
        if (isTitleAndYearCorrect(searchTitle, searchYear)) {
            for (Film film : allFilms) {
                if (film.getTitle().equals(searchTitle) && film.getYear() == searchYear) {
                    return film;
                }
            }
        }
        System.out.println("There is no match for this title and year. Null returned!");
        return null;
    }

    public boolean deleteFilm(String title, int year) {
        if (!isTitleAndYearCorrect(title, year)) {
            System.out.println("Film wasn't deleted!");
            return false;
        }
        Film foundFilm = getFilm(title, year);
        if (foundFilm == null) {
            System.out.println("There is no match for this title and year. Film wasn't deleted!");
            return false;
        }
        allFilms.remove(foundFilm);
        return true;
    }

    public FilmsLibrary allFilmsByActor(String searchName, String searchSurname) {
        if (isNameSurnameEmpty(searchName, searchSurname)) {
            System.out.println("Null returned!");
            return null;
        }
        FilmsLibrary playInFilms = new FilmsLibrary();
        for (Film film : allFilms) {
            if (film.getActor(searchName, searchSurname) != null) {
                playInFilms.addFilm(film);
            }
        }
        return playInFilms;
    }

    public Set<Film> getFilmCollection() {
        return allFilms;
    }

    public void showAllFilms() {
        for (Film film : allFilms) {
            System.out.println(film.toString());
        }
    }
}
