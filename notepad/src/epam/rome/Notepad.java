package epam.rome;

public class Notepad {
    private static final int MIN_ARRAY_LENGTH = 32;
    private int notesCount;
    private NotepadRecord[] allNotes;

    Notepad() {
        notesCount = 0;
        allNotes = new NotepadRecord[MIN_ARRAY_LENGTH];
    }

    public NotepadRecord getNote(int noteNumber) {
        return allNotes[noteNumber];
    }

    // Пока только набросок
    public void addNote(NotepadRecord note) {
        allNotes[notesCount] = note;
        notesCount++;
    }

    // В процессе написания реализации
    public void deleteNote(int noteNumber) {
        if (noteNumber >= 0 && noteNumber < notesCount) {
            // allNotes[noteNumber] = allNotes[notesCount - 1];
            // allNotes[notesCount - 1] = null;
            allNotes[noteNumber].replaceRecord(allNotes[notesCount - 1]);
            allNotes[notesCount - 1].replaceRecord(null);
            notesCount--;
            this.resizeArray();
        }
    }

    public void showNote(int noteNumber) {
        allNotes[noteNumber].showRecord();
    }

    public void showAllNotes() {
        for (int i = 0; i < notesCount; i++) {
            System.out.println(i);
            allNotes[i].showRecord();
        }
    }

    public int numberOfNotes() {
        return notesCount;
    }

    // Пока только набросок реализации
    private void resizeArray() {
        if ((allNotes.length > MIN_ARRAY_LENGTH) && (notesCount < allNotes.length / 2)) {
            //int newArraySize = allNotes.length / 32 * 16 + allNotes.length;
            //System.arraycopy(src, srcPos, dest, destPos, length);
        }
    }
}
