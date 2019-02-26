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

    NotepadRecord(String title, String text) {
        noteTitle = title;
        noteText = text;
        lastChange = new Date();
    }

    // Ждёт переопределения toString
    public void showRecord() {
        System.out.println("Title: " + noteTitle);
        System.out.println("Text: " + noteText);
        System.out.println("Changed: " + lastChange);
        System.out.println();
        //System.out.println(this);
    }

    public void changeTitle(String newTitle) {
        noteTitle = newTitle;
        dateUpdate();
    }

    public void changeText(String newText) {
        noteText = newText;
        dateUpdate();
    }

    public void replaceRecord(NotepadRecord newNote) {
        this.noteText = newNote.noteText;
        this.noteTitle = newNote.noteTitle;
        this.lastChange = newNote.lastChange;
    }
    @Override
    public String toString() {
        //StringBuilder sb = new StringBuilder();
        return "";
    }
    
    private Date dateUpdate() {
        lastChange = new Date();
        return lastChange;
    }
}
