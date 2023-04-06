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
        System.out.format("%.3f * (cos(%.3f) + sin(%.3f))\n", r, phi, phi);
    }

    /**
     * Method to create new object of the Matrix class
     * @return new object of the Matrix class
     */
    public static Matrix CreateMatrix(){
        int m = 0;
        int n = 0;
        boolean IsBreak = false;
        Matrix new_matrix = new Matrix(m, n);
        try {
            m = sc.nextInt();
            n = sc.nextInt();
        } catch (java.util.InputMismatchException e){
            System.out.println("You can set the dimensions only by numbers");
            sc = new Scanner(System.in);
            IsBreak = true;
        }
        if (m <= 0 || n <= 0 || IsBreak){
            System.out.println("Wrong dimensions");
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

    /**
     * Method to print matrix
     * @param matrix - matrix to be printed
     */
    public static void PrintMatrix(Matrix matrix){
        int m = matrix.GetCountOfRows();
        int n = matrix.GetCountOfColumns();
        System.out.println("Matrix:");
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix.GetMatrix()[i][j] == null){
                    System.out.print(0.0+"+"+0.0+"i  ");
                } else{
                    PrintComplex(matrix.GetMatrix()[i][j]);
                    PrintSpaces(matrix, i, j);
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Method to transpose matrix and print transposed matrix
     * @param matrix - matrix to be transposed and printed
     */
    public static void PrintTranspMatrix(Matrix matrix){
        int n = matrix.GetCountOfRows();
        int m = matrix.GetCountOfColumns();
        Matrix t_matrix = new Matrix(m, n);
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                t_matrix.GetMatrix()[i][j] = matrix.GetMatrix()[j][i];
            }
        }
        System.out.print("Transposed ");
        PrintMatrix(t_matrix);
    }

    /**
     * Helper method for beautiful matrix output
     * @param matrix - matrix to be printed
     * @param i - index of current loop element is outside the method
     * @param j - index of current loop element is outside the method
     */
    public static void PrintSpaces(Matrix matrix, int i, int j){
        int MaxLen = MaxLenOfNumber(matrix, j);
        double real = matrix.GetMatrix()[i][j].GetReal();
        double imagin = matrix.GetMatrix()[i][j].GetImagin();
        String str = real+"+"+imagin+"i";
        int CountOfSpaces = MaxLen - str.length();
        for (int k = 0; k < CountOfSpaces; k++){
            System.out.print(" ");
        }
    }

    /**
     * Helper method for beautiful matrix output
     * @param matrix - matrix to be printed
     * @param j - index of current loop element is outside the method
     * @return the largest length of number in the current column of the matrix
     */
    public static int MaxLenOfNumber(Matrix matrix, int j){
        int MaxLen = 0;
        double real, imagin;
        for (Complex[] row : matrix.GetMatrix()) {
            real = row[j].GetReal();
            imagin = row[j].GetImagin();
            String str = real + "+" + imagin + "i";
            if (str.length() > MaxLen) {
                MaxLen = str.length();
            }
        }
        return MaxLen;
    }

    /**
     * Method to work with user commands
     * @return true - the program continues to work, false - finish the program
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
        Matrix matrix1;
        Matrix matrix2;
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
                    System.out.println();
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
                    result = complex1.Add(complex2);
                    System.out.print("\nResult: ");
                    PrintComplex(result);
                    System.out.println();
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
                    result = complex1.Subtract(complex2);
                    System.out.print("\nResult: ");
                    PrintComplex(result);
                    System.out.println();
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
                    result = complex1.Multiply(complex2);
                    System.out.print("\nResult: ");
                    PrintComplex(result);
                    System.out.println();
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
                System.out.print("Enter the dimensions of the matrix as M N, separating them with a space or a new line. M - rows, N - columns. Example: 2 5\nEnter: ");
                new_matrix = CreateMatrix();
                if (new_matrix.GetCountOfRows() > 0 && new_matrix.GetCountOfColumns() > 0) {
                    System.out.println("Matrix created");
                    PrintMatrix(new_matrix);
                }
                System.out.println("\nEnter the number of the function you want to do. Enter 1 to view the list of functions");
                break;
            case 8:
                System.out.print("Enter the dimensions of the matrix as M N, separating them with a space or a new line. M - rows, N - columns. Example: 2 5\nEnter: ");
                new_matrix = CreateMatrix();
                new_matrix.FillMatrix();
                PrintMatrix(new_matrix);
                System.out.println("\nEnter the number of the function you want to do. Enter 1 to view the list of functions");
                break;
            case 9:
                System.out.print("Enter the first matrix:\nEnter the dimensions of the matrix as M N, separating them with a space or a new line. M - rows, N - columns. Example: 2 5\nEnter: ");
                matrix1 = CreateMatrix();
                matrix1.FillMatrix();
                System.out.print("\nEnter the second matrix:\nEnter the dimensions of the matrix as M N, separating them with a space or a new line. M - rows, N - columns. Example: 2 5\nEnter: ");
                matrix2 = CreateMatrix();
                matrix2.FillMatrix();
                if (matrix1.GetCountOfRows() == matrix2.GetCountOfRows() && matrix1.GetCountOfColumns() == matrix2.GetCountOfColumns()){
                    new_matrix = matrix1.AddMatrices(matrix2);
                    System.out.print("\nResult ");
                    PrintMatrix(new_matrix);
                } else {
                    System.out.println("Addition is impossible");
                }
                System.out.println("\nEnter the number of the function you want to do. Enter 1 to view the list of functions");
                break;
            case 10:
                System.out.print("Enter the first matrix:\nEnter the dimensions of the matrix as M N, separating them with a space or a new line. M - rows, N - columns. Example: 2 5\nEnter: ");
                matrix1 = CreateMatrix();
                matrix1.FillMatrix();
                System.out.print("\nEnter the second matrix:\nEnter the dimensions of the matrix as M N, separating them with a space or a new line. M - rows, N - columns. Example: 2 5\nEnter: ");
                matrix2 = CreateMatrix();
                matrix2.FillMatrix();
                int m = matrix2.GetCountOfRows();
                int n = matrix1.GetCountOfColumns();
                if (m == n){
                    new_matrix = matrix1.MultiplyMatrices(matrix2, matrix1.GetCountOfRows(), matrix2.GetCountOfColumns(), n);
                    System.out.print("\nResult ");
                    PrintMatrix(new_matrix);
                } else {
                    System.out.println("Multiplication is impossible");
                }
                System.out.println("\nEnter the number of the function you want to do. Enter 1 to view the list of functions");
                break;
            case 11:
                System.out.print("Enter the dimensions of the matrix as M N, separating them with a space or a new line. M - rows, N - columns. Example: 2 5\nEnter: ");
                new_matrix = CreateMatrix();
                new_matrix.FillMatrix();
                PrintMatrix(new_matrix);
                PrintTranspMatrix(new_matrix);
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