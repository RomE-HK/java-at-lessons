package epam.rome.moviescollection;

import epam.rome.moviescollection.model.Film;
import epam.rome.moviescollection.model.FilmsSet;

import java.io.*;

import static epam.rome.moviescollection.model.Tools.isStringEmpty;

public class Main {
    static FilmsSet myCollection;
    static StringBuilder info = new StringBuilder();
    static String userInput = "";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        startMenu();
        if (myCollection == null) {
            return;
        }
        // mainMenu();


        if (myCollection.getFilmCollection().size() == 0) {

            Film firstFilm = new Film();
            firstFilm.setGenre("History");

            firstFilm.addActor("Tim", "Roth", 1865);
            firstFilm.addActor("Grace", "Brown", 1868);

            myCollection.addFilm(firstFilm);
            myCollection.addFilm("La voltige", 1980);
            myCollection.showAllFilms();

            System.out.println("Enter file name:");
            userInput = inputRead();

        } else {
            myCollection.showAllFilms();

            System.out.println("Enter the title of new film:");
            String newFilmTitle = inputRead();
            System.out.println("Enter the year of new film:");
            int yearOfNewFilmTitle = Integer.parseInt(inputRead());
            myCollection.addFilm(newFilmTitle, yearOfNewFilmTitle);

            myCollection.showAllFilms();

            System.out.println("Enter file name:");
            userInput = inputRead();
            saveCollection(userInput);
        }
    }

    public static void startMenu() {
        boolean menuRepeat = true;
        while (menuRepeat) {

            info = new StringBuilder();
            info.append("\nChoose wisely:\n");
            info.append("1 - New collection\n");
            info.append("2 - Load collection\n");
            info.append("0 - Exit program \n");

            System.out.println(info);
            userInput = inputRead();
            switch (userInput) {
                case ("1"):
                    myCollection = newCollection();
                    menuRepeat = false;
                    break;
                case ("2"):
                    System.out.println("Enter file name:");
                    userInput = inputRead();
                    myCollection = loadCollection(userInput);
                    menuRepeat = false;
                    break;
                case ("0"):
                    menuRepeat = false;
                    break;
                default:
                    break;
            }
            System.out.println("\nHello there\n");
        }
    }

    public static void mainMenu() {

    }

    public static FilmsSet newCollection() {
        return new FilmsSet();
    }

    public static FilmsSet loadCollection(String filename) {
        if (new File(filename + ".dat").exists()) {
            return myCollection = deserializeCollection(filename);
        }
        System.out.println("There is no such file! Create new?");
        System.out.println("Type \"yes\" to create. Or type anything else to cancel");
        userInput = inputRead();
        if (userInput.equals("yes")) {
            return newCollection();
        }
        return null;
    }

    public static void saveCollection(String filename) {
        if (!new File(filename + ".dat").exists()) {
            serializeCollection(myCollection, filename);
            return;
        }
        System.out.println("File already exist! Type \"yes\", to overwrite or saving would be canceled");
        userInput = inputRead();
        if (userInput.equals("yes")) {
            new File(filename + ".dat").delete();
            serializeCollection(myCollection, filename);
        }
    }

    public static String inputRead() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = "";
        try {
            userInput = br.readLine();
        } catch (IOException e) {
            System.out.println("Exception catched");
            return userInput;
        }
        return userInput;
    }

    public static void serializeCollection(FilmsSet collection, String filename) {
        if (isStringEmpty(filename))
        {
            System.out.println("Filename cannot be empty. Operation canceled");
            return;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename + ".dat"))) {
            oos.writeObject(collection);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static FilmsSet deserializeCollection(String filename) {
        if (isStringEmpty(filename))
        {
            System.out.println("Filename cannot be empty. Null returned");
            return null;
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename + ".dat"))) {
            return (FilmsSet)ois.readObject();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
