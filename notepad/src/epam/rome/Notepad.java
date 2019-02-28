package epam.rome;

import java.util.Arrays;

public class Notepad {
    private static final int MIN_ARRAY_LENGTH = 32;
    private int notesCount;
    private NotepadRecord[] allNotes;

    Notepad() {
        notesCount = 0;
        allNotes = new NotepadRecord[MIN_ARRAY_LENGTH];
    }

    // Нужен ли этот геттер? -_-
    public NotepadRecord getNote(int noteIndex) {
        if ((noteIndex >= 0) && (noteIndex < notesCount)) {
            return allNotes[noteIndex];
        } else
            return null;
    }

    // Пока только набросок
    public void addNote(NotepadRecord note) {
        if (note instanceof NotepadRecord) {
            allNotes[notesCount] = note;
            notesCount++;
            resizeArray();
        } else {
            System.out.println("Wrong input type of data");
        }
    }

    public void delNote(int noteIndex) {
        if ((noteIndex >= 0) && (noteIndex < notesCount)) {
            if (noteIndex < notesCount - 1) {
                allNotes[noteIndex] = allNotes[notesCount - 1];
            }
            allNotes[notesCount - 1] = null;
            // allNotes[noteIndex].replaceRecord(allNotes[notesCount - 1]);
            // allNotes[notesCount - 1].replaceRecord(null);
            notesCount--;
            resizeArray();
            System.out.println("Note deleted");
        } else {
            System.out.println("Wrong note index");
        }
    }

    public void showNote(int noteIndex) {
        if ((noteIndex >= 0) && (noteIndex < notesCount)) {
            allNotes[noteIndex].showRecord();
        }
    }

    public void showAllNotes() {
        for (int i = 0; i < notesCount; i++) {
            System.out.println(i + " pos in allNotes");
            System.out.println(i + 1 + " ordinal number");
            allNotes[i].showRecord();
        }
    }

    public int numberOfNotes() {
        return notesCount;
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

        // Поправить вызов этого куска
        NotepadRecord[] newArray = Arrays.copyOf(allNotes, newArraySize);
        allNotes = newArray;
        System.out.println("Resize completed succesfully");
        return;
    }
}
