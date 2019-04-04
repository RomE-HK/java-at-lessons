package epam.rome.moviescollection.model;

public class Tools {
    private Tools() {}

    public static boolean isStringEmpty(String value){
        return value == null || "".equals(value.trim());
    }

    public static boolean isNameSurnameEmpty(String name, String surname) {
        if (isStringEmpty(name) || isStringEmpty(surname)) {
            System.out.println("Name or surname is empty");
            return true;
        }
        return false;
    }
}
