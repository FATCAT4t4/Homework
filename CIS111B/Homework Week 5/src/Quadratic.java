//imports
import org.apache.commons.math3.complex.Complex;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.Desktop;
/**
 * Represents a quadratic equation of the form y = ax^2 + bx + c.
 *
 * @author Jacob Sowden
 * @version 1
 */
public class Quadratic {
    //Initializations
    /**
     * The coefficient of the quadratic term (a).
     */
    private double a;
    /**
     * The coefficient of the linear term (b).
     */
    private double b;
    /**
     * The constant term (c).
     */
    private double c;
    private String appId = "6469XY-P72X963A72";
    /**
     * Constructs a new quadratic equation with the default coefficients.
     */
    //Default constructor, has the form y = x^2 + x with no coefficients
    public Quadratic() {
        this.a = 1;
        this.b = 1;
        this.c = 0;
    }
    /**
     * Constructs a new quadratic equation with the given coefficients.
     *
     * @param a the coefficient of the quadratic term
     * @param b the coefficient of the linear term
     * @param c the constant term
     */
    //Constructor that allows for the defining of all three coefficients
    public Quadratic(double a, double b, double c) {
        setA(a);
        setB(b);
        setC(c);
    }
    /**
     * Sets the coefficient of the quadratic term (a).
     *
     * @param a  the coefficient of the quadratic term
     */
    //Setters for a, b and c
    public void setA(double a) {
        try{
            this.a = a;
        }
        catch (ClassCastException e){
            throw new IllegalArgumentException("a must be a double value.", e);
        }
    }
    /**
     * Sets the coefficient of the linear term (b).
     *
     * @param b  the coefficient of the linear term
     */
    public void setB(double b) {
        try{
            this.b = b;
        }
        catch(ClassCastException e){
            throw new IllegalArgumentException("b must be a double value.", e);
        }
    }
    /**
     * Sets the coefficient of the constant term (c).
     *
     * @param c  the coefficient of the constant term
     */
    public void setC(double c) {
        try{
            this.c = c;
        }
        catch(ClassCastException e){
            throw new IllegalArgumentException("c must be a double value.", e);
        }
    }
    /**
     * Returns the coefficient of the quadratic term (a).
     *
     * @return the coefficient of the quadratic term as a double
     */
    //Getters for a, b and c
    public double getA() {
        return this.a;
    }
    /**
     * Returns the coefficient of the linear term (b).
     *
     * @return the coefficient of the linear term as a double
     */
    public double getB() {
        return this.b;
    }
    /**
     * Returns the coefficient of the constant term (c).
     *
     * @return the coefficient of the constant term as a double
     */
    public double getC() {
        return this.c;
    }
    /**
     * Returns whether the discriminant is negative.
     *
     * @return true if the discriminant is negative, false otherwise
     */
    //Tells if discriminant is negative
    public boolean isDiscriminantNegative() {
        if (getB() * getB() - 4 * getA() * getC() < 0) {
            return true;
        }
        return false;
    }
    /**
     * Returns whether the quadratic equation has real roots.
     *
     * @return true if the equation has real roots, false otherwise
     */
    //Tells if there are real roots
    public boolean hasRealRoots() {
        if (getB() * getB() - 4 * getA() * getC() >= 0) {
            return true;
        }
        return false;
    }
    /**
     * Returns the discriminant of the quadratic equation (b^2 - 4ac).
     *
     * @return the discriminant as a double
     */
    //Get the discriminant
    public double getDiscriminant() {
        return getB() * getB() - 4 * getA() * getC();
    }
    /**
     * Returns a string representation of the quadratic equation.
     *
     * @return a string representation of the equation
     */
    //Get the equation
    public String getEquation(){
        return "y = " + getA() + "x^2 + " + getB() + "x + " + getC();
    }
    /**
     * Returns the roots of the quadratic equation.
     *
     * @return an array of Complex objects representing the roots
     */
    // Solve the quadratic equation, returns an array of complex numbers, even if the roots are both real. Complex numbers are formatted (real, imaginary).
    public Complex[] solve() {
        Complex[] roots = new Complex[2];
        if (isDiscriminantNegative()) {
            double realPart = -getB() / (2 * getA());
            double imaginaryPart = Math.sqrt(-getDiscriminant()) / (2 * getA());
            roots[0] = new Complex(realPart, imaginaryPart);
            roots[1] = new Complex(realPart, -imaginaryPart);
        }
        else {
            roots[0] = new Complex((-getB() + Math.sqrt(getDiscriminant())) / (2 * getA()), 0);
            roots[1] = new Complex((-getB() - Math.sqrt(getDiscriminant())) / (2 * getA()), 0);
        }
        return roots;
    }
    /**
     * Find the derivative of a given x value.
     *
     * @return the derivative as a double
     */
    //Find the derivative of a given x value
    public double derivative(double x) {
        return (x * getA())+getB();
    }
    /**
     * Graphs the quadratic equation using the Wolfram Alpha API, and opens it in the default image viewer.
     */
    //Use the Wolfram Alpha Simple API to download a .png image of the graph and open it with the default image viewer
    public void graph(){
        try {
            // Set the quadratic equation
            String equation = "y=" + getA() + "x^2+plus" + getB() + "x+plus" + getC();      //Have to use the word "plus" instead of "+" because the api interprets "+" as " "
            // Set the API endpoint and parameters
            String apiEndpoint = "http://api.wolframalpha.com/v1/simple?appid=" + appId + "&i=" + equation + "+plot";       //"+plot" ensures the image only includes the graph
            // Send the request to the API
            URL url = new URL(apiEndpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get the response from the API
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {      //HTTPS response code 200 means "OK"
                // Get the image from the response
                BufferedImage image = ImageIO.read(connection.getInputStream());
                // Save the image to a file
                String filename = "quadratic_graph.png";
                try (FileOutputStream writer = new FileOutputStream(filename)) {
                    ImageIO.write(image, "png", writer);
                    File file = new File(filename);
                    Desktop.getDesktop().open(file);
                } catch (FileNotFoundException e) {
                    System.out.println("Error saving image to file: " + e.getMessage());
                }
            } else {
                System.out.println("Error: " + responseCode);       //Error code 400 means request is missing an input parameter, error code 501 means the api is unable to process the given input parameters
            }
        }
        catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    /**
     * Prints all values to a string.
     */
    //Print everything to string
    public String toString() {
        Complex[] complex = solve();        //Needed to print the roots in a standard format instead of the (real, imaginary) format.
        if (hasRealRoots()) {       //If the roots are real, print them without the "+0.0i" imaginary part.
            return "Equation: y = " + getA() + "x^2 + " + getB() + "x + " + getC() + " Discriminant: " + getDiscriminant() + " Is discriminant negative?: " + isDiscriminantNegative() + " Real roots?: " + hasRealRoots() + " Roots:" + complex[0].getReal() + ", " + complex[1].getReal();
        }
        return "Equation: y = " + getA() + "x^2 + " + getB() + "x + " + getC() + " Discriminant: " + getDiscriminant() + " Is discriminant negative?: " + isDiscriminantNegative() + " Real roots?: " + hasRealRoots() + " Roots:" + complex[0].getReal() + " + " + complex[0].getImaginary() + "i, " + complex[1].getReal() +  " + " + complex[1].getImaginary() + "i";
    }
}