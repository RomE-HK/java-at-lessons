package epam.rome;

public class Main {

    public static void main(String[] args) {
        Notepad pad = new Notepad();

        NotepadRecord note0 = new NotepadRecord("Zoglavie", "Test your luck!");
        pad.setNote(note0);
        NotepadRecord note1 = new NotepadRecord("Zaglavie", "Test your might!");
        pad.setNote(note1);
        NotepadRecord note2 = new NotepadRecord("Zagolovock", "Test your strength!");
        pad.setNote(note2);

        for (int i = 0; i < pad.getNumberNotes(); i++) {
            pad.getNote(i);
        }
    }
}
