package ua.com.consolenotebook;

/**
 * Created by TAI on 06.02.14.
 */
public class Runner {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ConsoleNoteBook noteBook = new ConsoleNoteBook();
        while (true) {
            noteBook.consoleNoteBook();
        }
    }
}
