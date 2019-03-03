package epam.rome;

public class Main {

    public static void main(String[] args) {
        Notepad pad = new Notepad();

        NotepadRecord note0 = new NotepadRecord("Zoglavie", "Test your luck!");
        NotepadRecord note1 = new NotepadRecord("Zaglavie", "Test your might!");
        NotepadRecord note2 = new NotepadRecord("Zagolovock", "Test your strength!");

        for (int i = 0; i < 50; i++) {
            pad.addNote(note0);
            pad.addNote(note1);
            pad.addNote(note2);
        }
        pad.addNote(null);

        for (int i = 0; i < 30; i++) {
            pad.delNote(35);
            pad.delNote(16);
            pad.delNote(2);
            pad.delNote(1);
        }

        NotepadRecord freshNote = new NotepadRecord("WTF", "Why am I here?");
        pad.replaceNote(freshNote, 29);

        NotepadRecord noteChange = pad.getNote(200); //Вернёт пустую запись вместо null
        noteChange.changeTitle("Hi!");
        noteChange.changeText("Let's rock!");
        pad.replaceNote(noteChange, 200); // Скажет о неверном индексе

        pad.replaceNote(null, 18); // Выдаст сообщение вида "Ты втираешь мне какую-то дичь"
        
        noteChange = pad.getNote(28); // Тут всё гладко
        noteChange.changeTitle("Hi!");
        noteChange.changeText("Let's rock!");
        pad.replaceNote(noteChange, 28); // Тут всё гладко

        pad.addNote(new NotepadRecord());

        pad.showAllNotes();

        pad.titleSort();
        pad.dateSort();

        System.out.println(pad.numberOfNotes());
    }
}
