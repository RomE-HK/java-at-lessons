package epam.rome;

public class Main {

    public static void main(String[] args) {
        Notepad pad = new Notepad();

        NotepadRecord note0 = new NotepadRecord("Zoglavie", "Test your luck!");
        pad.addNote(note0);
        NotepadRecord note1 = new NotepadRecord("Zaglavie", "Test your might!");
        pad.addNote(note1);
        NotepadRecord note2 = new NotepadRecord("Zagolovock", "Test your strength!");
        pad.addNote(note2);

        pad.showAllNotes();
        System.out.println(pad.numberOfNotes());

        /* for (int i = 0; i < pad.numberOfNotes(); i++) {
            pad.getNote(i).dateUpdate();
        }
        pad.showAllNotes();
        System.out.println(pad.numberOfNotes()); */
    }
}
