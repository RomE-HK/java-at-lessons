package epam.rome.moviescollection.model;

import java.io.Serializable;
import java.util.Calendar;

public class Actor implements Serializable {
    private String name;
    private String surname;
    private int yearOfBorn;

    public Actor() {
        this("John", "Smith");
    }

    public Actor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }


    public void setYearOfBorn(int year) {
        yearOfBorn = year;
    }

    public String getFullName() {
        return name + " " + surname;
    }


    public int getYearOfBorn() {
        return yearOfBorn;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getFullName() + System.lineSeparator());
        int ages = Calendar.getInstance().get(Calendar.YEAR) - getYearOfBorn();
        builder.append("Age of " + ages).append(", " + getYearOfBorn());
        return builder.toString();
    }
}
