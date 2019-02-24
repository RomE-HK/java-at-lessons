package epam.rome;

import java.util.Date;

public class NotepadRecord {
    private String noteTitle;
    private String noteText;
    private Date lastChange;

    NotepadRecord() {
        noteTitle = "";
        noteText = "";
        lastChange = new Date();
    }

    NotepadRecord(String title, String note) {
        noteTitle = title;
        noteText = note;
        lastChange = new Date();
    }

    public void ShowRecord() {
        System.out.println("Title: " + noteTitle);
        System.out.println("Text: " + noteText);
        System.out.println("Changed: " + lastChange);
        System.out.println();
    }
}
