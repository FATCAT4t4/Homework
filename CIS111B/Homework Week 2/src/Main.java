//Imports
import java.util.Arrays;
import java.util.HashSet;
import org.apache.commons.statistics.descriptive.Max;
import org.apache.commons.statistics.descriptive.Mean;
import org.apache.commons.statistics.descriptive.Median;
import org.apache.commons.statistics.descriptive.Min;


public class Main {
    public static void main(String[] args) {
        boolean result = new Main().unique("%&$(@^)");        //Put a string into the unique method, returns true if all characters are unique and false if there are duplicates
        double[] ticketStuff = new Main().tickets();        //Call the tickets method, returns a double array of the mean, median, maximum, and minimum, in that order.
    }


    public boolean unique(String string){
        String[] characters = string.split("");     //Split string into individual characters in an array
        HashSet<String> set = new HashSet<>();      //Create a new empty HashSet
        for(String character : characters){     //Add each character to the HashSet
            if (!set.add(character)){
                return false;       //If it finds a duplicate return false
            }
        }
        return true;        //If it gets through the loop with no duplicates return true
    }


    public double[] tickets(){
        double[] array = {54,159,35,57,52,49,59,33,48,33,40,14,58,37,47,33,29,25,25}; //Array of all the ticket prices
//        //Find average
//        Mean mean = Mean.of(array);
//        double ticketAverage = mean.getAsDouble();
//        //Find median
//        Median median = Median.withDefaults();
//        double ticketMedian = median.evaluate(array);
//        //Find max and min
//        Max max = Max.of(array);
//        Min min = Min.of(array);
//        double ticketMax = max.getAsDouble();
//        double ticketMin = min.getAsDouble();

//        This stuff was all working, but it stopped working when I restarted my computer and I couldn't figure out why, so below is the code rewritten without the Apache Commons libraries.


        // Find average
        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        double ticketAverage = sum / array.length;

        // Find median
        Arrays.sort(array);
        double ticketMedian;
        if (array.length % 2 == 0) {
            ticketMedian = (array[array.length / 2 - 1] + array[array.length / 2]) / 2.0;
        } else {
            ticketMedian = array[array.length / 2];
        }

        // Find max and min
        double ticketMax = array[array.length - 1];
        double ticketMin = array[0];
//return values as a double array
        double[] ticketStats = {ticketAverage, ticketMedian, ticketMax, ticketMin};
        return ticketStats;
    }
}