package epam.rome.moviescollection.model;

import java.io.Serializable;
import java.util.Calendar;

public class Actor implements Serializable {
    private String name;
    private String surname;
    private String sex;
    private int yearOfBorn;

    public Actor() {
        this("John", "Smith");
    }

    public Actor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setYearOfBorn(int year) {
        yearOfBorn = year;
    }

    public String getFullName() {
        return name + surname;
    }

    public String getSex() {
        return sex;
    }

    public int getYearOfBorn() {
        return yearOfBorn;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getFullName() + System.lineSeparator());
        builder.append(sex + System.lineSeparator());
        int ages = Calendar.getInstance().get(Calendar.YEAR) - yearOfBorn;
        builder.append("Age of " + ages).append(", " + yearOfBorn);
        return builder.toString();
    }
}
