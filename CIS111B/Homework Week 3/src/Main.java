import java.util.ArrayList;

/**
 * The Main class demonstrates various operations on arrays and ArrayLists in Java.
 * It includes methods to create, modify, and print lists of Beatles members.
 *
 * <p>Operations demonstrated include:
 * <ul>
 *   <li>Creating and initializing arrays and ArrayLists</li>
 *   <li>Adding elements to specific positions in arrays and ArrayLists</li>
 *   <li>Removing elements from arrays and ArrayLists</li>
 *   <li>Converting an ArrayList to an array</li>
 *   <li>Printing elements of arrays and ArrayLists</li>
 *   <li>Calculating the size of arrays and ArrayLists</li>
 *   <li>Doubling the size of arrays and ensuring capacity of ArrayLists</li>
 * </ul>
 * </p>
 *
 * <p>Usage:
 * <pre>
 * {@code
 * // To run the code, press the Run button or click the Execute icon in the gutter.
 * public class Main {
 *     public static void main(String[] args) {
 *         String[] beatles = listArray();
 *         ArrayList<String> beatles2 = listArrayList();
 *         String[] converted = new String[beatles2.size()];
 *         for (int i = 0; i < beatles2.size(); i++) {
 *             converted[i] = beatles2.get(i);
 *         }
 *     }
 * }
 * }
 * </pre>
 * </p>
 *
 * @see java.util.ArrayList
 */
public class Main {
    /**
     * The main method serves as the entry point for the program.
     * It demonstrates the conversion of an ArrayList to an array.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        String[] beatles = listArray();
        ArrayList<String> beatles2 = listArrayList();
        String[] converted = new String[beatles2.size()];        //Convert an arraylist to an array
        for (int i = 0; i < beatles2.size(); i++) {
            converted[i] = beatles2.get(i);
        }
    }
    /**
     * Creates and modifies an array of Beatles members.
     * Demonstrates adding, removing, and printing elements, as well as resizing the array.
     *
     * @return A modified array of Beatles members.
     */
    public static String[] listArray(){
        String[] beatles = new String[2];       //Create the list
        beatles[0] = "Ringo Starr";
        beatles[1] = "Paul McCartney";
        String[] temp = beatles;        //Add an item to the middle of the list
        beatles = new String[temp.length+1];
        beatles[0] = temp[0];
        beatles[1] = "John Lennon";
        beatles[2] = temp[1];
        temp = beatles;     //Add an item to the beginning of the list.
        beatles = new String[temp.length+1];
        beatles[0] = "George Harrison";
        beatles[1] = temp[0];
        beatles[2] = temp[1];
        beatles[3] = temp[2];
        temp = beatles;     //Add an item to the end of the list.
        beatles = new String[temp.length+1];
        beatles[0] = temp[0];
        beatles[1] = temp[1];
        beatles[2] = temp[2];
        beatles[3] = temp[3];
        beatles[4] = "Pete Best";
        temp = beatles;     //Remove an item from the list.
        beatles = new String[temp.length-1];
        beatles[0] = temp[0];
        beatles[1] = temp[1];
        beatles[2] = temp[2];
        beatles[3] = temp[3];
        for (String beatle : beatles) {     //Print the list
            System.out.println(beatle);
        }
        int size = beatles.length;      //Calculate list size
        temp = beatles;     //Double size of the list
        beatles = new String[temp.length*2];
        beatles[0] = temp[0];
        beatles[1] = temp[1];
        beatles[2] = temp[2];
        beatles[3] = temp[3];
        return beatles;
    }
    /**
     * Creates and modifies an ArrayList of Beatles members.
     * Demonstrates adding, removing, and printing elements, as well as ensuring capacity.
     *
     * @return A modified ArrayList of Beatles members.
     */
    public static ArrayList<String> listArrayList(){
        ArrayList<String> beatles = new ArrayList();        //Create an arraylist
        beatles.add("Ringo Starr");
        beatles.add("Paul McCartney");      //Add an item to the end of the arraylist
        beatles.add(1,"John Lennon");       //Add an item to the middle of the arraylist
        beatles.add(0,"George Harrison");       //Add an item to the beginning of the arraylist
        for (String beatle : beatles) {     //Print the arraylist
            System.out.println(beatle);
        }
        beatles.remove(beatles.indexOf("Paul McCartney"));       //Remove an item from the arraylist
        int size = beatles.size();      //Calculate the size of the arraylist
        beatles.ensureCapacity(size*2);     //Double the size of the arraylist (not necessary for arraylists, they just expand when you add more stuff to them automatically)
        return beatles;
    }

}