package lv.ctco.notepad;

public abstract class Record { //komanda new ne budet rabotatj dlja recorda
    private static int counter = 0;
    private int id;


    public Record() {
        counter++;
        id = counter;
    }

    public abstract boolean contains(String str);
    public abstract void askData();

    public int getId() {
        return id;
    }

}
