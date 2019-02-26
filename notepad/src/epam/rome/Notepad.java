package epam.rome;

public class Notepad {
    private static int notesCount;
    private final int minArrayLength;
    private NotepadRecord[] allNotes;

    Notepad() {
        notesCount = 0;
        minArrayLength = 32;
        allNotes = new NotepadRecord[minArrayLength];
    }

    private void resizeArray() {
        if ((allNotes.length > minArrayLength) && (notesCount < allNotes.length / 2)) {
            //int newArraySize = allNotes.length / 32 * 16 + allNotes.length;
            //System.arraycopy(src, srcPos, dest, destPos, length);
        }
    }

    public NotepadRecord getNote(int noteNumber) {
        return allNotes[noteNumber];
    }

    public void addNote(NotepadRecord note) {
        allNotes[notesCount] = note;
        notesCount++;
    }

    public void deleteNote(int noteNumber) {
        if (noteNumber >= 0 && noteNumber < notesCount) {
            allNotes[noteNumber].replaceRecord(allNotes[notesCount - 1]);
            allNotes[notesCount -1].replaceRecord(null);
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
}
