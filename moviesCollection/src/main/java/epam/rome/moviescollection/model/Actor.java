package epam.rome.moviescollection.model;

import java.io.Serializable;
import java.util.Calendar;

import static epam.rome.moviescollection.model.Tools.isStringEmpty;

public class Actor implements Serializable {
    private String name;
    private String surname;
    private int yearOfBorn;

    private static final String DEFAULT_NAME = "John";
    private static final String DEFAULT_SURNAME = "Smith";
    private static final int DEFAULT_YEAR_OF_BORN = 1700;

    public Actor() {
        this(DEFAULT_NAME, DEFAULT_SURNAME, DEFAULT_YEAR_OF_BORN);
    }

    public Actor(String name, String surname, int yearOfBorn) {
        setName(name);
        setSurname(surname);
        setYearOfBorn(yearOfBorn);
    }

    public void setName(String name) {
        if (isStringEmpty(name)) {
            System.out.println("Name was set to default because of empty string");
            this.name = DEFAULT_NAME;
            return;
        }
        this.name = name;
    }

    public void setSurname(String surname) {
        if (isStringEmpty(surname)) {
            System.out.println("Surname was set to default because of empty string");
            this.name = DEFAULT_SURNAME;
            return;
        }
        this.surname = surname;
    }

    public void setYearOfBorn(int yearOfBorn) {
        if (yearOfBorn < DEFAULT_YEAR_OF_BORN) {
            System.out.println("Year was set to default, cause actor was to old to be still alive in 1888!");
            this.yearOfBorn = DEFAULT_YEAR_OF_BORN;
            return;
        }
        this.yearOfBorn = yearOfBorn;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return getName() + " " + getSurname();
    }

    public int getYearOfBorn() {
        return yearOfBorn;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getFullName() + System.lineSeparator()); // ВОПРОС: ВЫЗОВ МЕТОДА ИЛИ ОБРАЩЕНИЕ К ПОЛЮ
        int ages = Calendar.getInstance().get(Calendar.YEAR) - getYearOfBorn();
        builder.append("Age of " + ages).append(", " + getYearOfBorn());
        return builder.toString();
    }
}
