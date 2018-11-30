package lv.ctco.notepad;

import java.time.LocalDate;

public class Reminder extends StickyNotes {
    private LocalDate date;


    @Override
    public boolean contains(String str) {
        return super.contains(str) //estj li u parenta eta stroka
                || getFormattedDate().contains(str); // || <-- OR, berjom datu i formatirujem  string
    }

    public void askData() {
        date = Main.askDate("Reminder date");
        super.askData();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reminder{ " +
                "id" + getId() +
                ", date'" + getFormattedDate() + '\'' +
                ", text'" + getText() + '\'' +
                '}';

    }

    private String getFormattedDate() {
        return date.format(Main.DATE_FORMATTER);
    }
}


