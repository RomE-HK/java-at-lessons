package epam.rome.moviescollection;

import epam.rome.moviescollection.model.Actor;
import epam.rome.moviescollection.model.Film;
import epam.rome.moviescollection.model.FilmsSet;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        if (!new File("moviesCollection.dat").exists()) {
            FilmsSet myCollection = new FilmsSet();

            Film firstFilm = new Film();
            firstFilm.setGenre("History");

            firstFilm.addActor("Tim", "Roth", 1865);
            firstFilm.addActor("Grace", "Brown", 1868);

            myCollection.addFilm(firstFilm);
            myCollection.addFilm("La voltige", 1980);
            myCollection.showAllFilms();
            serializeCollection(myCollection);
        } else {
            FilmsSet myCollection = deserializeCollection();
            myCollection.showAllFilms();

            System.out.println("Enter the title of new film:");
            String newFilmTitle = inputRead();
            System.out.println("Enter the year of new film:");
            int yearOfNewFilmTitle = Integer.parseInt(inputRead());
            myCollection.addFilm(newFilmTitle, yearOfNewFilmTitle);

            myCollection.showAllFilms();
            serializeCollection(myCollection);
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

    public static void serializeCollection(FilmsSet collection) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("moviesCollection.dat"))) {
            oos.writeObject(collection);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static FilmsSet deserializeCollection() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("moviesCollection.dat"))) {
            return (FilmsSet)ois.readObject();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
