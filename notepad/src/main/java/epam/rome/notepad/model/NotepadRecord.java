package epam.rome.notepad.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotepadRecord {
    private String title;
    private String text;
    private Date lastChange;

    public NotepadRecord() {
        title = "Default";
        text = "Default";
        lastChange = new Date();
    }

    public NotepadRecord(String title, String text) {
        this.title = title;
        this.text = text;
        lastChange = new Date();
    }

    public void changeTitle(String newTitle) {
        title = newTitle;
        dateUpdate();
    }

    public void changeText(String newText) {
        text = newText;
        dateUpdate();
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return lastChange;
    }

    public void showRecord() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Title: " + title + "\n");
        builder.append("Text: " + text + "\n");
        SimpleDateFormat formatForFate = new SimpleDateFormat("dd.MM.yyyy kk:mm:ss");
        builder.append("Changed: " + formatForFate.format(lastChange) + "\n");
        return builder.toString();
    }

    private void dateUpdate() {
        lastChange = new Date();
    }
}
