package epam.rome.moviescollection.model;

import java.io.Serializable;
import java.util.TreeSet;

public class FilmsSet implements Serializable {
    private TreeSet<Film> allFilms;

    public FilmsSet() {
        allFilms = new TreeSet<>();
    }

    public void addFilm(Film newFilm) {
        if (newFilm != null) {
            allFilms.add(newFilm);
        } else {
            System.out.println("The object of Film cannot be null");
        }
    }

    public void addFilm(String title, int year) {
        Film newFilm = new Film(title, year);
        addFilm(newFilm);
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

    public void editFilm(String title, int year, String genre) {
        Film film = getFilm(title, year);
        getFilm(title, year).toString();
        film.setTitle(title);
        film.setYear(year);
        film.setGenre(genre);
    }

    public void showAllFilms() {
        for (Film film : allFilms) {
            System.out.println(film.getTitle() + ", " + film.getYear());
        }
    }
}
