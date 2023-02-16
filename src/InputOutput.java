import java.util.Scanner;
/**
 * Class for input and output
 * @author Julia Komarova
 */
public class InputOutput {
    private static Scanner sc = new Scanner(System.in);
    /**
     * Method to get a complex number from user and create new object of the Complex class
     * @return new object of the Complex class
     */
    public static Complex InputAndCreateComplex(){
        String parts = sc.next();
        //
        double real = Double.parseDouble(parts.substring(0, parts.indexOf(',')));
        double imagin = Double.parseDouble(parts.substring(parts.indexOf(',') + 1));
        return new Complex(real, imagin);
    }
    /**
     * Method to print complex number in the form of a+bi
     * @param number - complex number to be printed
     */
    public static void PrintComplex(Complex number){
        double a = number.GetReal();
        double b = number.GetImagin();
        System.out.print(a+"+"+b+"i");
//        double a = number.GetReal();
//        double b = number.GetImagin();
//        if (a == 0){
//            System.out.println(b+"i");
//        } else if (b == 0){
//            System.out.println(a);
//        } else{
//            System.out.println(a+"+"+b+"i");
//        }
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
    public static Matrix CreateMatrix(){
        int m = 0;
        int n = 0;
        boolean IsBreak = false;
        Matrix new_matrix = new Matrix(m, n);
        try {
            m = sc.nextInt();
            n = sc.nextInt();
        } catch (java.util.InputMismatchException e){
            System.out.println("You can set the sizes only by numbers");
            sc = new Scanner(System.in);
            IsBreak = true;
        }
        if (m < 0 || n < 0 || IsBreak){
            System.out.println("Wrong sizes");
            IsBreak = true;
        }
        if (!IsBreak){
            try {
                new_matrix = new Matrix(m, n);
            } catch (Exception e){
                System.out.println("Error");
            }
        }
        return new_matrix;
    }
    public static Complex[][] FillMatrix(Matrix matrix){
        Complex[][] matrix_elem = matrix.GetMatrix();
        int m = matrix.GetCountOfRows();
        int n = matrix.GetCountOfColumns();
        System.out.println("Enter the elements of the matrix number by number. Enter first the real part of a complex number, then the imaginary part, separating them with a comma. If one of the parts is missing, write 0 instead.\nExample: 1.2,3.78");
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                System.out.format("Enter matrix[%d][%d]: ", i, j);
                try {
                    matrix_elem[i][j] = InputAndCreateComplex();
                } catch (Exception e){
                    System.out.println("Invalid input. Try again");
                    //
                }
            }
        }
        return matrix_elem;
    }
    public static void PrintMatrix(Complex[][] matrix, int n){
        System.out.println("Matrix:");
        for (Complex[] row: matrix){
            for (int j = 0; j < n; j++){
                if (row[j] == null){
                    System.out.print(0.0+"+"+0.0+"i  ");
                } else{
                    PrintComplex(row[j]);
                    System.out.print("  ");
                    //
                }
            }
            System.out.println("");
        }
    }
    public static void PrintTranspMatrix(Matrix matrix, int n, int m){
        Complex[][] matrix_elem = matrix.GetMatrix();
        Matrix t_matrix = new Matrix(m, n);
        Complex[][] transp_matrix = t_matrix.GetMatrix();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                transp_matrix[i][j] = matrix_elem[j][i];
            }
        }
        System.out.print("Transposed ");
        PrintMatrix(transp_matrix, n);
    }
    /**
     *Method to work with user commands
     */
    public static boolean Functions() {
        int func;
        try {
            func = sc.nextInt();
        } catch (java.util.InputMismatchException e){
            System.out.println("Enter the command NUMBER");
            sc = new Scanner(System.in);
            func = sc.nextInt();
        }
        Complex complex1 = new Complex();
        Complex complex2 = new Complex();
        Complex result;
        Matrix new_matrix;
        Complex[][] matrix_result;
        Matrix matrix1;
        Matrix matrix2;
        Complex[][] matrix1_elem;
        Complex[][] matrix2_elem;
        boolean IsBreak; // false - program works, true - program is broken
        switch (func){
            case 1:
                System.out.println("1 - print this menu;\n2 - create a complex number;\n3 - add two complex numbers;\n4 - subtract the second complex number from the first complex number;\n5 - multiply two complex numbers;\n6 - print a complex number in trigonometric form;\n7 - create a matrix;\n8 - set matrix elements;\n9 - add two matrices;\n10 - multiply two matrices;\n11 - matrix transposition;\n12 - finish the program");
                break;
            case 2:
                try {
                    System.out.print("Enter first the real part of a complex number, then the imaginary part, separating them with a comma. If one of the parts is missing, write 0 instead.\nExample: 1.2,3.78\nEnter: ");
                    Complex complex = InputAndCreateComplex();
                    System.out.print("Complex number created: ");
                    PrintComplex(complex);
                    System.out.println("");
                } catch (Exception e){
                    System.out.println("Invalid input");
                }
                System.out.println("\nEnter the number of the function you want to do. Enter 1 to view the list of functions");
                break;
            case 3:
                IsBreak = false;
                try {
                    System.out.print("Enter the first complex number:\nEnter first the real part of a complex number, then the imaginary part, separating them with a comma. If one of the parts is missing, write 0 instead.\nExample: 1.2,3.78\nEnter: ");
                    complex1 = InputAndCreateComplex();
                    System.out.print("\nEnter the second complex number:\nEnter first the real part of a complex number, then the imaginary part, separating them with a comma. If one of the parts is missing, write 0 instead.\nExample: 1.2,3.78\nEnter: ");
                    complex2 = InputAndCreateComplex();
                } catch (Exception e){
                    System.out.println("Invalid input");
                    IsBreak = true;
                }
                if (!IsBreak) {
                    result = Complex.Add(complex1, complex2);
                    System.out.print("\nResult: ");
                    PrintComplex(result);
                    System.out.println("");
                }
                System.out.println("\nEnter the number of the function you want to do. Enter 1 to view the list of functions");
                break;
            case 4:
                IsBreak = false;
                try {
                    System.out.print("Enter the first complex number - minuend:\nEnter first the real part of a complex number, then the imaginary part, separating them with a comma. If one of the parts is missing, write 0 instead.\nExample: 1.2,3.78\nEnter: ");
                    complex1 = InputAndCreateComplex();
                    System.out.print("\nEnter the second complex number - subtrahend:\nEnter first the real part of a complex number, then the imaginary part, separating them with a comma. If one of the parts is missing, write 0 instead.\nExample: 1.2,3.78\nEnter: ");
                    complex2 = InputAndCreateComplex();
                } catch (Exception e){
                    System.out.println("Invalid input");
                    IsBreak = true;
                }
                if (!IsBreak) {
                    result = Complex.Subtract(complex1, complex2);
                    System.out.print("\nResult: ");
                    PrintComplex(result);
                    System.out.println("");
                }
                System.out.println("\nEnter the number of the function you want to do. Enter 1 to view the list of functions");
                break;
            case 5:
                IsBreak = false;
                try {
                    System.out.print("Enter the first complex number:\nEnter first the real part of a complex number, then the imaginary part, separating them with a comma. If one of the parts is missing, write 0 instead.\nExample: 1.2,3.78\nEnter: ");
                    complex1 = InputAndCreateComplex();
                    System.out.print("\nEnter the second complex number:\nEnter first the real part of a complex number, then the imaginary part, separating them with a comma. If one of the parts is missing, write 0 instead.\nExample: 1.2,3.78\nEnter: ");
                    complex2 = InputAndCreateComplex();
                } catch (Exception e){
                    System.out.println("Invalid input");
                    IsBreak = true;
                }
                if (!IsBreak) {
                    result = Complex.Multiply(complex1, complex2);
                    System.out.print("\nResult: ");
                    PrintComplex(result);
                    System.out.println("");
                }
                System.out.println("\nEnter the number of the function you want to do. Enter 1 to view the list of functions");
                break;
            case 6:
                try {
                    System.out.print("Enter first the real part of a complex number, then the imaginary part, separating them with a comma. If one of the parts is missing, write 0 instead.\nExample: 1.2,3.78\nEnter: ");
                    Complex complex = InputAndCreateComplex();
                    System.out.print("\nTrigonometric form: ");
                    PrintTrigComplex(complex);
                } catch (Exception e){
                    System.out.println("Invalid input");
                }
                System.out.println("\nEnter the number of the function you want to do. Enter 1 to view the list of functions");
                break;
            case 7:
                System.out.print("Enter the sizes of the matrix as M N, separating them with a space or a new line. M - rows, N - columns. Example: 2 5\nEnter: ");
                new_matrix = CreateMatrix();
                System.out.println("Matrix created");
                PrintMatrix(new_matrix.GetMatrix(), new_matrix.GetCountOfColumns());
                System.out.println("\nEnter the number of the function you want to do. Enter 1 to view the list of functions");
                break;
            case 8:
                System.out.print("Enter the sizes of the matrix as M N, separating them with a space or a new line. M - rows, N - columns. Example: 2 5\nEnter: ");
                new_matrix = CreateMatrix();
                Complex[][] matrix_elements = FillMatrix(new_matrix);
                PrintMatrix(matrix_elements, new_matrix.GetCountOfColumns());
                System.out.println("\nEnter the number of the function you want to do. Enter 1 to view the list of functions");
                break;
            case 9:
                System.out.print("Enter the first matrix:\nEnter the sizes of the matrix as M N, separating them with a space or a new line. M - rows, N - columns. Example: 2 5\nEnter: ");
                matrix1 = CreateMatrix();
                matrix1_elem = FillMatrix(matrix1);
                System.out.print("Enter the second matrix:\nEnter the sizes of the matrix as M N, separating them with a space or a new line. M - rows, N - columns. Example: 2 5\nEnter: ");
                matrix2 = CreateMatrix();
                matrix2_elem = FillMatrix(matrix2);
                if (matrix1.GetCountOfRows() == matrix2.GetCountOfRows() && matrix1.GetCountOfColumns() == matrix2.GetCountOfColumns()){
                    matrix_result = Matrix.AddMatrices(matrix1_elem, matrix2_elem, matrix1.GetCountOfRows(), matrix1.GetCountOfColumns());
                    new_matrix = new Matrix(matrix_result);
                    matrix_result = new_matrix.GetMatrix();
                    PrintMatrix(matrix_result, new_matrix.GetCountOfColumns());
                } else {
                    System.out.println("Addition is impossible");
                }
                System.out.println("\nEnter the number of the function you want to do. Enter 1 to view the list of functions");
                break;
            case 10:
                System.out.print("Enter the first matrix:\nEnter the sizes of the matrix as M N, separating them with a space or a new line. M - rows, N - columns. Example: 2 5\nEnter: ");
                matrix1 = CreateMatrix();
                matrix1_elem = FillMatrix(matrix1);
                System.out.print("Enter the second matrix:\nEnter the sizes of the matrix as M N, separating them with a space or a new line. M - rows, N - columns. Example: 2 5\nEnter: ");
                matrix2 = CreateMatrix();
                matrix2_elem = FillMatrix(matrix2);
                int m = matrix2.GetCountOfRows();
                int n = matrix1.GetCountOfColumns();
                if (m == n){
                    matrix_result = Matrix.MultiplyMatrices(matrix1_elem, matrix2_elem, matrix1.GetCountOfRows(), matrix2.GetCountOfColumns(), n);
                    new_matrix = new Matrix(matrix_result);
                    matrix_result = new_matrix.GetMatrix();
                    PrintMatrix(matrix_result, matrix2.GetCountOfColumns());
                } else {
                    System.out.println("Multiplication  is impossible");
                }
                System.out.println("\nEnter the number of the function you want to do. Enter 1 to view the list of functions");
                break;
            case 11:
                System.out.print("Enter the sizes of the matrix as M N, separating them with a space or a new line. M - rows, N - columns. Example: 2 5\nEnter: ");
                new_matrix = CreateMatrix();
                Complex[][] matrix_elem = FillMatrix(new_matrix);
                PrintMatrix(matrix_elem, new_matrix.GetCountOfColumns());
                PrintTranspMatrix(new_matrix, new_matrix.GetCountOfRows(), new_matrix.GetCountOfColumns());
                System.out.println("\nEnter the number of the function you want to do. Enter 1 to view the list of functions");
                break;
            case 12:
                return false;
            default:
                System.out.println("Non-existent command\nEnter the right number of the function you want to do. Enter 1 to view the list of functions");
        }
    return true;
    }
}