import java.util.Scanner;
/**
 * Class for input and output
 * @author Julia Komarova
 */
public class InputOutput {
    private static final Scanner sc = new Scanner(System.in);
    /**
     * Method to get a complex number from user and create new object of the Complex class
     * @return new object of the Complex class
     */
    public static Complex InputAndCreateComplex(){
        System.out.println("Enter first the real part of a complex number, then the imaginary part, separating them with a comma. If one of the parts is missing, write 0 instead.\nExample: 1.2,3.78");
        System.out.print("Enter: ");
        String parts = sc.next();
        double real = Double.parseDouble(parts.substring(0, parts.indexOf(',')));
        double imagin = Double.parseDouble(parts.substring(parts.indexOf(',') + 1));
        return new Complex(real, imagin);
    }
    /**
     * Method to print complex number in the form of a+bi
     * @param number - complex number to be printed
     */
    public static void PrintComplex(Complex number){
        System.out.println(number.GetReal()+"+"+number.GetImagin()+"i");
    }
    /**
     * Method to print complex number in trigonometric form
     * @param number - complex number to be printed
     */
    public static void PrintTrigComplex(Complex number){
        double a = number.GetReal();
        double b = number.GetImagin();
        double r = Math.sqrt(a*a+b*b);
        double phi = Math.atan2(b, a);
        System.out.println(r+"*(cos("+phi+")+sin("+phi+"))");
    }
    /**
     *Method to work with user commands
     */
    public static boolean Functions() {
        int func = sc.nextInt();
        Complex complex1 = new Complex();
        Complex complex2 = new Complex();
        Complex result;
        boolean Break; // false - program works, true - program is broken
        switch (func){
            case 1:
                System.out.println("1 - print this menu;\n2 - create a complex number;\n3 - add two complex numbers;\n4 - subtract the second complex number from the first complex number;\n5 - multiply two complex numbers;\n6 - print a complex number in trigonometric form;\n7 - create a matrix;\n8 - set matrix elements;\n9 - add two matrices;\n10 - multiply two matrices;\n11 - matrix transposition;\n12 - calculate the determinant of the matrix;\n13 - finish the program");
                break;
            case 2:
                try {
                    Complex complex = InputAndCreateComplex();
                    System.out.print("\nComplex number created: ");
                    PrintComplex(complex);
                } catch (Exception e){
                    System.out.println("Invalid input");
                }
                System.out.println("\nEnter the number of what you want to do. Enter 1 to view the list of functions");
                break;
            case 3:
                Break = false;
                try {
                    System.out.println("Enter the first complex number:");
                    complex1 = InputAndCreateComplex();
                    System.out.println("\nEnter the second complex number:");
                    complex2 = InputAndCreateComplex();
                } catch (Exception e){
                    System.out.println("Invalid input");
                    Break = true;
                }
                if (!Break) {
                    result = Complex.Add(complex1, complex2);
                    System.out.print("\nResult: ");
                    PrintComplex(result);
                }
                System.out.println("\nEnter the number of what you want to do. Enter 1 to view the list of functions");
                break;
            case 4:
                Break = false;
                try {
                    System.out.println("Enter the first complex number - minuend:");
                    complex1 = InputAndCreateComplex();
                    System.out.println("\nEnter the second complex number - subtrahend:");
                    complex2 = InputAndCreateComplex();
                } catch (Exception e){
                    System.out.println("Invalid input");
                    Break = true;
                }
                if (!Break) {
                    result = Complex.Subtract(complex1, complex2);
                    System.out.print("\nResult: ");
                    PrintComplex(result);
                }
                System.out.println("\nEnter the number of what you want to do. Enter 1 to view the list of functions");
                break;
            case 5:
                Break = false;
                try {
                    System.out.println("Enter the first complex number:");
                    complex1 = InputAndCreateComplex();
                    System.out.println("\nEnter the second complex number:");
                    complex2 = InputAndCreateComplex();
                } catch (Exception e){
                    System.out.println("Invalid input");
                    Break = true;
                }
                if (!Break) {
                    result = Complex.Multiply(complex1, complex2);
                    System.out.print("\nResult: ");
                    PrintComplex(result);
                }
                System.out.println("\nEnter the number of what you want to do. Enter 1 to view the list of functions");
                break;
            case 6:
                try {
                    Complex complex = InputAndCreateComplex();
                    System.out.print("\nTrigonometric form: ");
                    PrintTrigComplex(complex);
                } catch (Exception e){
                    System.out.println("Invalid input");
                }
                System.out.println("\nEnter the number of what you want to do. Enter 1 to view the list of functions");
                break;
            case 7:
                //
                System.out.println("\nEnter the number of what you want to do. Enter 1 to view the list of functions");
                break;
            case 8:
                //
                System.out.println("\nEnter the number of what you want to do. Enter 1 to view the list of functions");
                break;
            case 9:
                //
                System.out.println("\nEnter the number of what you want to do. Enter 1 to view the list of functions");
                break;
            case 10:
                //
                System.out.println("\nEnter the number of what you want to do. Enter 1 to view the list of functions");
                break;
            case 11:
                //
                System.out.println("\nEnter the number of what you want to do. Enter 1 to view the list of functions");
                break;
            case 12:
                //
                System.out.println("\nEnter the number of what you want to do. Enter 1 to view the list of functions");
                break;
            case 13:
                return false;
            default:
                System.out.println("Invalid command\nEnter the right number of what you want to do. Enter 1 to view the list of functions");
        }
    return true;
    }
}