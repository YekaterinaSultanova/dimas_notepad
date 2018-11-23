package lv.ctco.notepad;

public class StickyNotes extends Record {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "StickyNotes{" +
                "text='" + text + '\'' +
                '}';
    }
}
