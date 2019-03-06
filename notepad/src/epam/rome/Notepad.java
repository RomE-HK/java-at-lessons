package epam.rome;

import java.util.Arrays;
import java.util.Comparator;

public class Notepad {
    private static final int MIN_ARRAY_LENGTH = 32;
    private static int notesCount;
    private static NotepadRecord[] allNotes;
    private static Notepad neoInstance = new Notepad();

    public static Notepad getInstance() {
        return neoInstance;
    }

    private Notepad() {
        notesCount = 0;
        allNotes = new NotepadRecord[MIN_ARRAY_LENGTH];
    }

    public NotepadRecord createNote(String title, String text) {
        if (title.length() > 0 || text.length() > 0) {
            return new NotepadRecord(title, text);
        }
        return new NotepadRecord();
    }

    public NotepadRecord getNote(int noteIndex) {
        if ((noteIndex >= 0) && (noteIndex < notesCount)) {
            return allNotes[noteIndex];
        } else {
            System.out.println("Empty object returned because of null at index");
            return new NotepadRecord();
            // Как вернуть не null? Только новая запись? Тогда получается она взялась ниоткуда
        }
    }

    public void addNote(NotepadRecord note) {
        if (note != null) {
            allNotes[notesCount] = note;
            notesCount++;
            resizeArray();
        } else {
            System.out.println("Wrong input type");
        }
    }

    public void delNote(int noteIndex) {
        if ((noteIndex >= 0) && (noteIndex < notesCount)) {
            if (noteIndex < notesCount - 1) {
                allNotes[noteIndex] = allNotes[notesCount - 1];
                // allNotes[noteIndex].replaceRecord(allNotes[notesCount - 1]);
            }
            allNotes[notesCount - 1] = null;
            // allNotes[notesCount - 1].replaceRecord(null);
            notesCount--;
            resizeArray();
            System.out.println("Note deleted");
        } else {
            System.out.println("Wrong note index");
        }
    }

    public void replaceNote(NotepadRecord note, int noteIndex) {
        if ((note != null) && (noteIndex >= 0) && (noteIndex < notesCount)) {
            allNotes[noteIndex] = note;
        } else {
            System.out.println("Wrong input type or index");
        }
    }

    public void showNote(int noteIndex) {
        if ((noteIndex >= 0) && (noteIndex < notesCount)) {
            allNotes[noteIndex].showRecord();
        } else {
            System.out.println("Wrong note index");
        }
    }

    public void showAllNotes() {
        for (int i = 0; i < notesCount; i++) {
            System.out.println(i + " pos in allNotes");
            System.out.println(i + 1 + " ordinal number");
            allNotes[i].showRecord();
        }
    }

    public int getNotesCount() {
        return notesCount;
    }

    public void dateSort() {
        Arrays.sort(allNotes, Comparator.comparing(NotepadRecord::getDate));
    }

    public void titleSort() {
        Arrays.sort(allNotes, Comparator.comparing(NotepadRecord::getTitle));
    }

    private void resizeArray() {
        int newArraySize;
        if (notesCount == allNotes.length) {
            newArraySize = allNotes.length / MIN_ARRAY_LENGTH * (MIN_ARRAY_LENGTH / 2) + allNotes.length;
            // Сделать нормальный коэффицент для увеличения массива

        } else if ((notesCount > MIN_ARRAY_LENGTH) && (notesCount < allNotes.length / 2)) {
            newArraySize = allNotes.length / 4 * 3; // Отрубаем у массива четверть, если используется меньше половины
        } else if ((notesCount < MIN_ARRAY_LENGTH) && (allNotes.length > MIN_ARRAY_LENGTH * 1.5)) {
            newArraySize = MIN_ARRAY_LENGTH; // Сжатие массива до минимального размера
        } else {
            System.out.println("Resize doesn't need");
            return;
        }

        NotepadRecord[] newArray = Arrays.copyOf(allNotes, newArraySize);
        allNotes = newArray;
        System.out.println("Resize completed succesfully");
    }
}
