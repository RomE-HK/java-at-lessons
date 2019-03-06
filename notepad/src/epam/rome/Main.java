package epam.rome;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        Menu.mainMenu();
    }

    static class Menu {
        static Notepad pad = Notepad.getInstance();
        static StringBuilder info = new StringBuilder();
        static String userInput = "";
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public static void mainMenu() {
            boolean menuRepeat = true;
            while (menuRepeat) {

                info = new StringBuilder();
                info.append("\nChoose wisely:\n");
                info.append("1 - Work with notes\n");
                info.append("2 - Showing notes and info\n");
                info.append("3 - (TESTING!) Sorting\n");
                info.append("9 - Test run\n");
                info.append("0 - Exit programm \n");

                System.out.println(info);
                userInput = inputRead();
                switch (userInput) {
                case ("1"):
                    workWithNotesMenu();
                    break;
                case ("2"):
                    notesAndInfoMenu();
                    break;
                case ("3"):
                    sortingMenu();
                    break;
                case ("9"):
                    someTestsRun();
                    //someTestsRun(pad);
                    break;
                case ("0"):
                    menuRepeat = false;
                    break;
                default:
                    break;
                }
                System.out.println("\nHello there\n");
            }
            return;
        }

        public static void workWithNotesMenu() {
            boolean menuRepeat = true;
            while (menuRepeat) {

                info = new StringBuilder();
                info.append("\nChoose wisely:\n");
                info.append("1 - New note\n");
                info.append("2 - Change note by index\n");
                info.append("3 - Delete note by index\n");
                info.append("0 - Go back\n");

                System.out.println(info);
                userInput = inputRead();
                switch (userInput) {
                case ("1"):
                    newNoteMenu();
                    break;
                case ("2"):
                    changeNoteMenu();
                    break;
                case ("3"):
                    System.out.println("Enter note index to delete");
                    try {
                        int noteToDelete = Integer.parseInt(inputRead());
                        pad.delNote(noteToDelete);
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong input");
                    }
                    break;
                case ("0"):
                    menuRepeat = false;
                    break;
                default:
                    break;
                }
            }
            return;
        }

        public static void newNoteMenu() {
            String title, text;
            boolean menuRepeat = true;
            while (menuRepeat) {

                info = new StringBuilder();
                info.append("\nChoose wisely:\n");
                info.append("1 - Add new one\n");
                info.append("2 - Replace old one\n");
                info.append("0 - Go back\n");

                System.out.println(info);
                userInput = inputRead();
                switch (userInput) {
                case ("1"):
                    System.out.println("Enter note title");
                    title = inputRead();
                    System.out.println("Enter note text");
                    text = inputRead();
                    pad.addNote(pad.createNote(title, text));
                    break;
                case ("2"):
                    System.out.println("Enter note title");
                    title = inputRead();
                    System.out.println("Enter note text");
                    text = inputRead();
                    System.out.println("Enter note index to replace");
                    try {
                        int noteToChange = Integer.parseInt(inputRead());
                        pad.replaceNote(pad.createNote(title, text), noteToChange);
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong input");
                    }
                    break;
                case ("0"):
                    menuRepeat = false;
                    break;
                default:
                    break;
                }
            }
            return;
        }

        public static void changeNoteMenu() {
            boolean menuRepeat = true;
            while (menuRepeat) {
                int noteToChange;
                info = new StringBuilder();

                System.out.println("Enter changing note index or something below 0 to exit");
                try {
                    noteToChange = Integer.parseInt(inputRead());
                    if (noteToChange < 0) {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input");
                    continue;
                }

                info.append("1 - Change title\n");
                info.append("2 - Change text\n");
                info.append("0 - Go back\n");

                System.out.println(info);
                userInput = inputRead();
                switch (userInput) {
                case ("1"):
                    System.out.println("Enter note title");
                    String title = inputRead();
                    pad.getNote(noteToChange).changeTitle(title);
                    break;
                case ("2"):
                    System.out.println("Enter note text");
                    String text = inputRead();
                    pad.getNote(noteToChange).changeTitle(text);
                    break;
                case ("0"):
                    menuRepeat = false;
                    break;
                default:
                    break;
                }
            }
            return;
        }

        public static void notesAndInfoMenu() {
            boolean menuRepeat = true;
            while (menuRepeat) {

                info = new StringBuilder();
                info.append("\nChoose wisely:\n");
                info.append("1 - Show note by index\n");
                info.append("2 - Show all notes\n");
                info.append("3 - Show notes count\n");
                info.append("0 - Go back\n");

                System.out.println(info);
                userInput = inputRead();

                switch (userInput) {
                case ("1"):
                    System.out.println("Enter note index to show");
                    try {
                        int noteToShow = Integer.parseInt(inputRead());
                        pad.showNote(noteToShow);
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong input");
                    }
                    break;
                case ("2"):
                    pad.showAllNotes();
                    break;
                case ("3"):
                    pad.getNotesCount();
                    break;
                case ("0"):
                    menuRepeat = false;
                    break;
                default:
                    break;
                }
            }
            return;
        }

        public static void sortingMenu() {
            boolean menuRepeat = true;
            while (menuRepeat) {

                info = new StringBuilder();
                info.append("\nChoose wisely:\n");
                info.append("1 - Sort by date\n");
                info.append("2 - Sort by title\n");
                info.append("0 - Go back\n");

                System.out.println(info);
                userInput = inputRead();

                switch (userInput) {
                case ("1"):
                    pad.dateSort();
                    break;
                case ("2"):
                    pad.titleSort();
                    break;
                case ("0"):
                    menuRepeat = false;
                    break;
                default:
                    break;
                }
            }
            return;
        }

        public static String inputRead() {
            String userInput = "";
            try {
                userInput = br.readLine();
            } catch (IOException e) {
                System.out.println("Exception catched");
                return userInput;
            }
            return userInput;
        }

        public static void someTestsRun() {
            Notepad pad = Notepad.getInstance();
            boolean sortTest = false;

            NotepadRecord note0 = new NotepadRecord("Zoglavie", "Test your luck!");
            NotepadRecord note1 = new NotepadRecord("Zaglavie", "Test your might!");
            NotepadRecord note2 = new NotepadRecord("Zagolovock", "Test your strength!");

            for (int i = 0; i < 50; i++) {
                pad.addNote(note0);
                pad.addNote(note1);
                pad.addNote(note2);
            }
            pad.addNote(null);

            for (int i = 0; i < 30; i++) {
                pad.delNote(35);
                pad.delNote(16);
                pad.delNote(2);
                pad.delNote(1);
            }

            NotepadRecord freshNote = new NotepadRecord("WTF", "Why am I here?");
            pad.replaceNote(freshNote, 29);

            NotepadRecord noteChange = pad.getNote(200); // Вернёт пустую запись вместо null
            noteChange.changeTitle("Hi!");
            noteChange.changeText("Let's rock!");
            pad.replaceNote(noteChange, 200); // Скажет о неверном индексе

            pad.replaceNote(null, 18); // Выдаст сообщение вида "Ты втираешь мне какую-то дичь"

            noteChange = pad.getNote(28); // Тут всё гладко
            noteChange.changeTitle("Hi!");
            noteChange.changeText("Let's rock!");
            pad.replaceNote(noteChange, 28); // Тут всё гладко

            pad.addNote(new NotepadRecord());

            pad.showAllNotes();

            if (sortTest) {
                pad.titleSort();
                pad.dateSort();
            }
            System.out.println(pad.getNotesCount());
        }
    }
}
