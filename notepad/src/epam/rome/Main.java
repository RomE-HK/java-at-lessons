package epam.rome;

public class Main {

    public static void main(String[] args) {
        Notepad pad = new Notepad();

        NotepadRecord note0 = new NotepadRecord("Zoglavie", "Test your luck!");
        NotepadRecord note1 = new NotepadRecord("Zaglavie", "Test your might!");
        NotepadRecord note2 = new NotepadRecord("Zagolovock", "Test your strength!");
        for (int i = 0; i < 50; i++) {
            pad.addNote(note0);
            pad.addNote(note1);
            pad.addNote(note2);
        }
        pad.addNote(null);

        pad.delNote(149);
        pad.delNote(22);
        pad.delNote(-1);

        pad.showAllNotes();
        System.out.println(pad.numberOfNotes());
    }
}
