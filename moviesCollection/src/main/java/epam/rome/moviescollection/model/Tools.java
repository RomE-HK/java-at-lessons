package epam.rome.moviescollection.model;

class Tools {
    private Tools() {}

    static boolean isStringEmpty(String value){
        return value == null || "".equals(value.trim());
    }

    static boolean isNameSurnameEmpty(String name, String surname) {
        if (isStringEmpty(surname)) {
            System.out.println("Surname cannot be empty");
            return true;
        }
        if (isStringEmpty(name)) {
            System.out.println("Name cannot be empty");
            return true;
        }
        return false;
    }

    static boolean isFilmYearTooSmall(int year) {
        return year < Film.DEFAULT_YEAR;
    }

    static boolean isTitleAndYearCorrect(String title, int year) {
        if (isStringEmpty(title)) {
            System.out.println("Title cannot be empty");
            return false;
        } else if (isFilmYearTooSmall(year)) {
            System.out.println("Film year too small");
            return false;
        }
        return true;
    }
}
