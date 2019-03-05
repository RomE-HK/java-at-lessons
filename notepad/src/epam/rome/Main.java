package epam.rome;

import java.io.BufferedReader;

public class Main {

    public static void main(String[] args) {
        Notepad pad = new Notepad();
        //BufferedReader bf = new BufferedReader(in);
        boolean working = true;
        StringBuilder info = new StringBuilder();

        info.append("Choose something:\n");
        info.append("1 - Work with notes\n");
        info.append("2 - Showing notes and info\n");
        info.append("3 - (TESTING!) Sorting\n");
        info.append("9 - Test run\n");

        if (working) {
            int userInput = 0;
            System.out.println(info);
            switch (userInput) {
                case (1):
                    workWithNotesMenu();
                    break;
                case (2):
                    notesAndInfoMenu();
                    break;
                case (3):
                    sortingMenu();
                    break;
                case (9):
                    someTestsRun(pad);
                    break;
                default:
                    break;
            }
        }
    }

    public static void workWithNotesMenu() {
        StringBuilder info = new StringBuilder();
        info.append("1 - New note\n");
        info.append("2 - Change by index\n");
        info.append("3 - Delete note by index\n");

        int userInput = 0;
        System.out.println(info);

        switch (userInput) {
            case (1):
                break;
            case (2):
                break;
            case (3):
                break;
            default:
                break;
        }
    }

    public static void newNoteMenu() {
        StringBuilder info = new StringBuilder();
        info.append("1 - Change title\n");
        info.append("2 - Change text\n");

        int userInput = 0;
        System.out.println(info);

        switch (userInput) {
            case (1):
                break;
            case (2):
                break;
            default:
                break;
        }
    }

    public static void changeNoteMenu() {
        StringBuilder info = new StringBuilder();
        info.append("1 - Add new one\n");
        info.append("2 - Replace old one\n");

        int userInput = 0;
        System.out.println(info);

        switch (userInput) {
            case (1):
                break;
            case (2):
                break;
            default:
                break;
        }
    }

    public static void notesAndInfoMenu() {
        StringBuilder info = new StringBuilder();
        info.append("1 - Show note by index\n");
        info.append("2 - Show all notes\n");
        info.append("3 - Show notes count\n");

        int userInput = 0;
        System.out.println(info);

        switch (userInput) {
            case (1):
                break;
            case (2):
                break;
            case (3):
                break;
            default:
                break;
        }
    }

    public static void sortingMenu() {
        StringBuilder info = new StringBuilder();
        info.append("1 - Sort by date\n");
        info.append("2 - Sort by title\n");

        int userInput = 0;
        System.out.println(info);

        switch (userInput) {
            case (1):
                break;
            case (2):
                break;
            default:
                break;
        }
    }

    public static void someTestsRun(Notepad pad) {
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
