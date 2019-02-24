package epam.rome;

public class Notepad {
    private static int notesCount;
    private NotepadRecord[] allNotes;
    
    Notepad() {
        notesCount = 0;
        allNotes = new NotepadRecord[32];
    }

    public void setNote(NotepadRecord note) {
        allNotes[notesCount] = note;
        notesCount++;
    }
    public void getNote(int noteNumber) {
        allNotes[noteNumber].ShowRecord();
    }

    public int getNumberNotes() {
        return notesCount;
    }
}
