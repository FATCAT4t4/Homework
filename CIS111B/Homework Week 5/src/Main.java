//imports
import org.apache.commons.math3.complex.Complex;
/**
 * The main class for the quadratic equation solver. Tests all the methods.
 *
 * @author FATCAT4t4
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        //Create a Quadratic object with the default constructor
        Quadratic quad = new Quadratic();
        //Print a, b, and c (expected values are 1, 1, 0)
        System.out.println(quad.getA());
        System.out.println(quad.getB());
        System.out.println(quad.getC());
        //Print the discriminant
        System.out.println(quad.getDiscriminant());
        //Print if discriminant is negative
        System.out.println(quad.isDiscriminantNegative());
        //Print if there are real roots
        System.out.println(quad.hasRealRoots());
        //Print the roots
        Complex[] roots = quad.solve();
        System.out.println(roots[0]);
        System.out.println(roots[1]);
        //Print the equation
        System.out.println(quad.getEquation());
        //Print everything to string
        System.out.println(quad.toString());
        //Set a, b, and c to values that will make the discriminant negative
        quad.setA(1);
        quad.setB(4);
        quad.setC(5);
        //Print the discriminant
        System.out.println(quad.getDiscriminant());
        //Print if discriminant is negative
        System.out.println(quad.isDiscriminantNegative());
        //Print if there are real roots
        System.out.println(quad.hasRealRoots());
        //Print the roots
        roots = quad.solve();
        System.out.println(roots[0]);
        System.out.println(roots[1]);
        //Print the equation
        System.out.println(quad.getEquation());
        //Print everything to string
        System.out.println(quad.toString());
        //Display the graph of the equation using the default image viewer
        quad.graph();
    }
}
