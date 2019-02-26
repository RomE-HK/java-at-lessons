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

    public void showRecord() {
        System.out.println("Title: " + noteTitle);
        System.out.println("Text: " + noteText);
        System.out.println("Changed: " + lastChange);
        System.out.println();
        //System.out.println(this);
    }

    private Date dateUpdate() {
        this.lastChange = new Date();
        return this.lastChange;
    }

    public void changeTitle(String newTitle) {
        this.noteTitle = newTitle;
        this.dateUpdate();
    }

    public void changeText(String newText) {
        this.noteText = newText;
        this.dateUpdate();
    }

    public void replaceRecord(NotepadRecord newNote) {
        this.noteText = newNote.noteText;
        this.noteTitle = newNote.noteTitle;
    }

    public String toString() {
        //StringBuilder sb = new StringBuilder();
        return "";
    }
}
