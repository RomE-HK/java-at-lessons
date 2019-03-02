package epam.rome;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotepadRecord {
    private String title;
    private String text;
    private Date lastChange;

    NotepadRecord() {
        title = "Default";
        text = "Default";
        lastChange = new Date();
    }

    NotepadRecord(String title, String text) {
        this.title = title;
        this.text = text;
        lastChange = new Date();
    }

    public void showRecord() {
        System.out.println(this);
    }

    public void changeTitle(String newTitle) {
        title = newTitle;
        dateUpdate();
    }

    public void changeText(String newText) {
        text = newText;
        dateUpdate();
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
    
    private Date dateUpdate() {
        lastChange = new Date();
        return lastChange;
    }
}
