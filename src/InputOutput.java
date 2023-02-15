import java.util.Scanner;
/**
 * Class for input and output
 */
public class InputOutput {
    private static final Scanner sc = new Scanner(System.in);

    public static Complex InputAndCreateComplex(){
        try {
            System.out.println("Enter first the real part of a complex number, then the imaginary part, separating them with a comma. If one of the parts is missing, write 0 instead.\nExample: 1.2,3.78");
            String parts = sc.next();
            double real = Double.parseDouble(parts.substring(0, parts.indexOf(',')));
            double imagin = Double.parseDouble(parts.substring(parts.indexOf(',') + 1));
            System.out.println("Complex number created: "+real+"+"+imagin+"i");
            return new Complex(real, imagin);
        } catch (Exception e){
            System.out.println("Invalid input");
            return new Complex();
        }
    }

    public static void Functions(){
        int func = sc.nextInt();
        switch (func){
            case 1:
                Complex complex = InputAndCreateComplex();
                System.out.println("\nEnter the number of what you want to do. Enter 11 to view the list of functions");
                break;
            case 2:
                //
                break;
            case 3:
                //
                break;
            case 4:
                //
                break;
            case 5:
                //
                break;
            case 6:
                //
                break;
            case 7:
                //
                break;
            case 8:
                //
                break;
            case 9:
                //
                break;
            case 10:
                //
                break;
            case 11:
                System.out.println("1 - create a complex number;\n2 - add two complex numbers;\n3 - multiply two complex numbers;\n4 - print a complex number in trigonometric form;\n5 - create a matrix;\n6 - set matrix elements;\n7 - add two matrices;\n8 - multiply two matrices;\n9 - matrix transposition;\n10 - calculate the determinant of the matrix;\n11 - print this menu");
                break;
            default:
                System.out.println("Invalid command");
        }
    }
}