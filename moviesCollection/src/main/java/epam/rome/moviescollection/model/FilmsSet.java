package epam.rome.moviescollection.model;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

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
        /* if (!isTitleAndYearCorrect(title, year)) {
            System.out.println("Film wasn't added!");
            return;     //ВОПРОС: ЕЩЁ ПРОВЕРКА НУЖНА, ВЕДЬ ПРИ СОЗДАНИИ АКТЁРА ОНА ПРОИСХОДИТ И ТАК?
        } */
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

    public void deleteFilm(String title, int year) {
        if (!isTitleAndYearCorrect(title, year)) {
            System.out.println("There is no match for this title and year");
            return;
        }
        Film foundFilm = getFilm(title, year);
        if (foundFilm == null) {
            System.out.println("Film wasn't deleted!");
            return;
        }
        allFilms.remove(foundFilm);
    }

    public FilmsSet allFilmsByActor(String searchName, String searchSurname) {
        if (isNameSurnameEmpty(searchName, searchSurname)) {
            System.out.println("Null returned!");
            return null;
        }
        FilmsSet playInFilms = new FilmsSet();
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
