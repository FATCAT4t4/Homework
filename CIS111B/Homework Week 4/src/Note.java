//Imports
import javax.sound.midi.*;

/**
 * Represents a musical note with properties such as length, value, and methods to manipulate and play the note.
 */
public class Note {
    //Declarations
    private String length;
    private int value;
    private final String[] notes = {"A", "A#/Bb", "B", "C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab"};

    /**
     * Default constructor setting a quarter note with A440 value.
     */
    // Default constructor setting A440 quarter note
    public Note() {
        this.length = "quarter";
        this.value = 0; // A440
    }

    /**
     * Constructor that sets the note length and defaults the value to A440.
     * @param length The length of the note.
     */
    //Constructor that just takes note length, leaving value as default (0/A440)
    public Note(String length) {
        this.setLength(length);
        this.value = 0; // A440
    }

    /**
     * Constructor that sets the note value and defaults the length to quarter.
     * @param value The value of the note.
     */
    //Constructor that just takes note value, leaving length as default (quarter)
    public Note(int value) {
        this.setValue(value);
        this.length = "quarter";
    }

    /**
     * Constructor that sets both the value and length of the note.
     * @param length The length of the note.
     * @param value The value of the note.
     */
    //Constructor that takes both value and length
    public Note(String length, int value) {
        this.setLength(length);
        this.setValue(value);
    }

    /**
     * Set the length of the note.
     * @param length The length of the note as a string.
     */
    //Set the length of the note, takes a string
    public void setLength(String length) {
        this.length = length.toLowerCase();
        if(!this.length.equals("quarter") && !this.length.equals("eight") && !this.length.equals("sixteenth") && !this.length.equals("half") && !this.length.equals("whole")){
            this.length = "quarter";
        }
    }

    /**
     * Set the value of the note.
     * @param value The value of the note as an integer.
     */
    //Set the value of the note, takes an integer
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Get the value of the note.
     * @return The value of the note as an integer.
     */
    //Get the value of the note as an integer
    public int getValue() {
        return this.value;
    }

    /**
     * Get the length of the note.
     * @return The length of the note as a string.
     */
    //Get the length of the note
    public String getLength() {
        return this.length;
    }

    /**
     * Get the letter name of the current note.
     * @return The letter name of the note.
     */
    //Get the letter name of the current note
    public String getLetterName(){
        return notes[Math.abs(this.value % 12)]; //% 12 to handle notes outside the first octave, Math.abs to handle negative values
    }

    /**
     * Check if the note is natural or sharp/flat.
     * @return True if the note is natural, false if it is sharp or flat.
     */
    //Return whether the note is natural or sharp/flat
    public boolean isNatural() {
        //%12 is for same reason as in getLetterName
        if(this.value%12 == 1 || this.value%12 == 4 || this.value%12 == 6 || this.value%12 == 9 || this.value%12 == 11) {
            return false;
        }
        return true;
    }

    /**
     * Get the frequency of the current note.
     * @return The frequency of the note.
     */
    //Get the frequency of the current note
    public double getFrequency() {
        return 440 * Math.pow(2, this.value / 12.0);     //The formula we were instructed to use in the homework
    }

    /**
     * Play the note using a MIDI synthesizer.
     */
    //Play the note using a midi synthesizer
    public void playNote() {
        if(this.value + 69 < 0){
            System.out.println(this.length + " is below the available MIDI range.");
        }
        else if(this.value+69 > 127){
            System.out.println(this.length + " is above the available MIDI range.");
        }
        else try {
            Synthesizer synth = MidiSystem.getSynthesizer();        //Create a new synthesizer
            synth.open();       //Starts the synthesizer
            MidiChannel[] channels = synth.getChannels();       //Gets the array of available MIDI channels
            channels[0].noteOn((this.value+69), 127);        //MIDI notes range from 0 to 127, with the A above middle C being number 69. Since this note equals 0 in our program, we add 69 to any value to get the corresponding MIDI note. Velocity is volume, 127 is the maximum.
            Thread.sleep(1500);     //Play note for 1.5 seconds, 1500 milliseconds
            channels[0].noteOff(this.value);        //Stop the note
            synth.close();      //Ends the synthesiser
        } catch (MidiUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get a string representation of the note including length, value, letter name, frequency, and natural status.
     * @return A string representation of the note.
     */
    //Print out all values in a single string
    public String toString(){
        return this.length + " " + this.value + " " + this.notes[Math.abs(this.value % 12)] + " " + this.getFrequency() + "Hz Natural?: " + this.isNatural();
    }
}