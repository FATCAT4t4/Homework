// okay let's start by using some packages of the Java API you may not have yet seen


import java.net.*;
import java.io.*;

//  NOTE::  You probably can't answer these without reading ahead through the code and making some best guesses !
// Question 1 : why are we using java.net package ? What classes are used from that package ? which methods of those classes?
//We are using java.net to connect to the API url. We are using the URL and URLConnection classes, and within them we are using the URL and openConnection methods.
// Question 2: why use the java.io package ? Which classes are we using ? why? which methods ? 
// We are using java.io to read the data in CSV.csv. The classes used are InputStreamReader and BufferedReader, and the methods within those are InputStreamReader, BufferedReader, readLine, and close.


public class API_PracticeEPA 
{

   // this first line states that the program may bail out , ie throw an Exception.
   //Q2: using the java api page for the class URL, find what Exception the constructor for the URL class can throw
   //The URL class can throw the MalformedURLException.
   public static void main(String[] args) throws Exception {
   
       // for later.... ! 
       String[] zipCodes={"87101", "19422", "19464"};
      
      // Now we are going to use a Web Service from the EPA, the Environmental Protection Agency.
      //
      // We'll create a query 
      // and have the EPA server talk to our program and send us the information we request. This is the main
      //mechanism for communication and xmission of information over the Internet, not printing to the screen!
      //
      //
      // Two popular formats that allow two computers to communicate are XML and JSON. As beginners we'll 
      // just use an easier format called CSV.
      // Q3. What is CSV? 
      //CSV stands for Comma Separated Value and is a data storage file format.
      // Q4: Go to the documentation page for the EPA API. 
      //   https://www.epa.gov/enviro/web-services#hourlyzip 
      // Run this program with the URL query as it is written below. What happens?
       //It gives a list of the UV values in zip code 87101 at different times of day, along with the city and state the zip code is in.
      // Copy the URL from the line below into a new tab of your browser. What does it return?
      //It downloads a file named CSV.csv, containing the data that was returned in the console.

       for (int i = 0; i < zipCodes.length; i++) {
           URL epaServer = new URL("https://enviro.epa.gov/enviro/efservice/getEnvirofactsUVHOURLY/ZIP/" + zipCodes[i] + "/CSV");


           URLConnection ac = epaServer.openConnection();


           InputStreamReader inputStream = new InputStreamReader(ac.getInputStream(), "UTF-8");
           BufferedReader bufferedReader = new BufferedReader(inputStream);
           StringBuilder responseBuilder = new StringBuilder();


           String line;

           while ((line = bufferedReader.readLine()) != null) {
               responseBuilder.append(line + "\n");

           }
           bufferedReader.close();

           // would rather just have you look at this in the debugger, but for now we'll print !
           System.out.println(responseBuilder.toString());
       }
     
       
    
   // Q5:: edit this program so that you query the EPA for UV levels at a list of locations (Central Campus, West Campus and Albuquerque, NM)
   // Your program should automatically run through this list of locations and retrieve the data from the EPA for each.   
          //Done :D
   }  // end of main
}// end of program

