package lv.ctco.notepad;

import com.sun.org.apache.xerces.internal.impl.dv.DTDDVFactory;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.time.format.DateTimeFormatter.*;


public class Main {
    public static final String DATE_PATTERN = "uuuu-MM-dd"; //final = constanta (bolwimi bukvami), nelza pomenjatj zna4enije posle inicializacii
    //public static final - eto konstanta ona neizmenna
    public static final DateTimeFormatter DATE_FORMATTER = ofPattern(DATE_PATTERN); //static import - stti4eskij metod vzal i mozhno ispolzovatj bez klassa
    static Scanner scanner = new Scanner(System.in);
    static List<Record> records = new ArrayList<>(); //spisok Recordsom sdelali abstraktnim, tam mozhno teperj hranitj ne toljko spisok Personov

    public static void main(String[] args) {
        for (; ; ) {
            System.out.print("cmd: ");
            String cmd = scanner.next();
            switch (cmd) {
                case "search":
                    search();
                    break;
                case "cr":
                case "createReminder":
                    createRecord(new Reminder());
                    break;
                case "cp": // mezhdu nimi net break i poetomu mozhno vvoditj bistro cp = create person
                case "createPerson":
                    createRecord(new Person());
                    break;
                case "cn":
                case "createNote":
                    createNote(new StickyNotes());
                    break;
                case "help":
                    showHelp();
                    break;
                case "delete":
                    deleteRecordById();
                case "list":
                    showList();
                    break;
                case "st":
                case "StickyNotes":
                    createRecord(new StickyNotes());
                    break;
                case "alarm":
                case "SetAlarm":
                    createAlarm(new Alarm());
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Wrong command. Try 'help'");
            }
        }
    }

    private static void createAlarm() {

    }

    private static void createNote(StickyNotes stickyNotes) {
        record.askString();
        records.add(StickyNotes);
        System.out.println(records);
    }

    private static void createSearch() {
        String ss = askString("What do you want to find?");
        for (Record r : records) {
            System.out.println(r);
        }
    }

    private static void deleteRecordById() {
        int id = askInt("ID to delete");
        for (int i = 0; i < records.size(); i++) {
            Record r = records.get(i);
            if (r.getId() == id) {
                records.remove(i);
                break;
            }
        }
        showList();
    }

    private static void showList() {
        records.forEach(System.out::println);
    }

    private static void showHelp() {
    }

    private static void search() {
        String ss = askString("What do you want to find?");

        records.stream()
                .filter(r -> r.contains(ss))
                .forEach(System.out::println);
    }

    private static void createRecord(Record record) {
        record.askData();
        records.add(record);
        System.out.println(record);
    }

    public static String askString(String msg) {
        for (;;) {
            System.out.print(msg + ": ");
            String val = scanner.next();
            if (!val.startsWith("\"")) {
                return val;
            }
            List<String> words = new ArrayList<>();
            words.add(val);
            while (!val.endsWith("\"")) {
                val = scanner.next();
                words.add(val);
            }
            String result = String.join(" ", words);
            result = result.substring(1, result.length() - 1);
            if (result.length() < 1) {
                System.out.println("at least one character, please");
                continue;
            }
            return result;
        }
    }

    public static int askInt(String msg) {
        System.out.print(msg + ": ");
        return scanner.nextInt();
    }

    public static String askPhone(String msg) {
        for (; ; ) {
            String result = askString(msg);
            boolean hasWrongChars = result.codePoints()
                    .anyMatch(c -> !(Character.isDigit(c) || Character.isSpaceChar(c) || c == '-' || c == '+'));
            if (hasWrongChars) {
                System.out.println("Only numbers, spaces dashes and pluses are allowed");
                continue;
            }

            long digitCount = result.codePoints()
                    .filter(Character::isDigit)
                    .count();
            if (digitCount < 5) {
                System.out.println("Should be 5 or more digits");
                continue;
            }

            return result;
        }
    }

    public static LocalDate askDate(String msg) {
        String strDate = askString(msg);
        return LocalDate.parse(strDate, DATE_FORMATTER);
    }
}


