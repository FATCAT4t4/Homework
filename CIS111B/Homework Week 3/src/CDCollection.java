//********************************************************************
//  CDCollection.java       Author: Lewis/Loftus
//
//  Represents a collection of compact discs.
//********************************************************************

import java.text.NumberFormat;

public class CDCollection
{
   private CD[] collection;
   private int count;
   private double totalCost;

   //-----------------------------------------------------------------
   //  Constructor: Creates an initially empty collection.
   //-----------------------------------------------------------------
   public CDCollection ()
   {
      collection = new CD[100];
      count = 0;
      totalCost = 0.0;
   }

   //-----------------------------------------------------------------
   //  Adds a CD to the collection, increasing the size of the
   //  collection if necessary.
   //-----------------------------------------------------------------
   public void addCD (String title, String artist, double cost,
                      int tracks)
   {
      if (count == collection.length)
         increaseSize();

      collection[count] = new CD (title, artist, cost, tracks);
      totalCost += cost;
      count++;
   }

   //-----------------------------------------------------------------
   //  Returns a report describing the CD collection.
   //-----------------------------------------------------------------
   public String toString()
   {
      NumberFormat fmt = NumberFormat.getCurrencyInstance();

      String report = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
      report += "My CD Collection\n\n";

      report += "Number of CDs: " + count + "\n";
      report += "Total cost: " + fmt.format(totalCost) + "\n";
      report += "Average cost: " + fmt.format(totalCost/count);

      report += "\n\nCD List:\n\n";

      for (int cd = 0; cd < count; cd++)
         report += collection[cd].toString() + "\n";

      return report;
   }

   //-----------------------------------------------------------------     //Comment that explains what the method does
   //  Increases the capacity of the collection by creating a
   //  larger array and copying the existing collection into it.
   //-----------------------------------------------------------------
   private void increaseSize ()     //Declares a new private method
   {     //Open bracket of the method
      CD[] temp = new CD[collection.length * 2];      //Creates a new array named temp, with a length double that of the collection array

      for (int cd = 0; cd < collection.length; cd++)     //For loop that loops as many times as there are spaces in the collection array
         temp[cd] = collection[cd];    //Sets each value in the temp array to that of the matching value in the collection array

      collection = temp;      //Sets collection equal to temp, keeping its original values and adding space for double the amount that was in it before
   }     //Close bracket of the method