/**
 * Class of complex numbers
 * @author Julia Komarova
 */
public class Complex {
    /**
     * real - real part of the complex number
     * imagin - imaginary part of the complex number
     */
    private final double real, imagin;
    /**
     * Constructor for creating a zero complex number
     */
    public Complex() {
        this(0.0, 0.0);
    }
    /**
     * Constructor for creating complex number with the specified real and imaginary parts
     * @param real - specified real part of the complex number
     * @param imagin - specified imaginary part of the complex number
     */
    public Complex(double real, double imagin) {
        this.real = real;
        this.imagin = imagin;
    }
    /**
     * Getter of real part of the complex number
     * @return real part of the complex number
     */
    public double GetReal(){
        return real;
    }
    /**
     * Getter of imaginary part of the complex number
     * @return imaginary part of the complex number
     */
    public double GetImagin(){
        return imagin;
    }
    /**
     * Method to add two complex numbers
     * @param number1 - first complex number
     * @param number2 - second complex number
     * @return result of adding two complex numbers
     */
    public static Complex Add(Complex number1, Complex number2){
        return new Complex(number1.GetReal()+number2.GetReal(), number1.GetImagin()+number2.GetImagin());
    }
    /**
     * Method to subtract the second complex number from the first complex number
     * @param number1 - first complex number
     * @param number2 - second complex number
     * @return result of subtracting two complex numbers
     */
    public static Complex Subtract(Complex number1, Complex number2){
        return new Complex(number1.GetReal()-number2.GetReal(), number1.GetImagin()-number2.GetImagin());
    }
    /**
     * Method to multiply two complex numbers
     * @param number1 - first complex number
     * @param number2 - second complex number
     * @return result of multiplying two complex numbers
     */
    public static Complex Multiply(Complex number1, Complex number2){
        return new Complex(number1.GetReal()*number2.GetReal() - number1.GetImagin()*number2.GetImagin(), number1.GetReal()*number2.GetImagin() + number1.GetImagin()*number2.GetReal());
    }
}