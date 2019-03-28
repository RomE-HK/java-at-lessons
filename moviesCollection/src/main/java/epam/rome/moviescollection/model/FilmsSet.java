package epam.rome.moviescollection.model;

import org.jetbrains.annotations.Nullable;

import java.util.TreeSet;

public class FilmsSet {
    private static TreeSet<Film> allFilms;

    public FilmsSet() {
        allFilms = new TreeSet<>();
    }

    public void addFilm(Film film) {
        allFilms.add(film);
    }

    @Nullable
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
            System.out.println(film.toString());
        }
    }

    /*public void showFilmCast(String title) {
        for (Film film : allFilms) {
            if (film.getTitle().contains(title)) {
                film.showCast();
            }
        }
    }*/
}
