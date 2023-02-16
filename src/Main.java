/**
 * @author Julia Komarova
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the number of the function you want to do:\n1 - print this menu;\n2 - create a complex number;\n3 - add two complex numbers;\n4 - subtract the second complex number from the first complex number;\n5 - multiply two complex numbers;\n6 - print a complex number in trigonometric form;\n7 - create a matrix;\n8 - set matrix elements;\n9 - add two matrices;\n10 - multiply two matrices;\n11 - matrix transposition;\n12 - finish the program");
        boolean run = true;
        while (run) {
            try {
                run = InputOutput.Functions();
            } catch (Exception e){
                System.out.println("Wrong command");
            }
        }
    }
}