/**
 * The Main class contains the main method to demonstrate the functionality of the Note class.
 */
public class Main {
    public static void main(String[] args) {
        //Declare a new Note note, a half note with a value of zero.
        Note note = new Note("HaLf", 0); //string formatted "HaLf" to show that it can accept any casing and still work
        //Print all information of the note to a string using toString()
        System.out.println(note.toString());
        //Set the note's new value to 27 using setValue()
        note.setValue(27);
        //Set the note's new length to whole using setLength()
        note.setLength("WHOLE");
        //Play the note using playNote()
        note.playNote();

    }
}