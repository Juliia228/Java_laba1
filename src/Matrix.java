/**
 * Class of matrices
 * @author Julia Komarova
 */
public class Matrix {
    /**
     * matrix - a matrix with complex values
     */
    private final Complex[][] matrix;

    /**
     * rows - count of rows of the matrix
     * columns - count of columns of the matrix
     */
    private int rows, columns;

    /**
     * Constructor for creating a zero matrix with dimensions row x col
     * @param row - count of rows of the matrix
     * @param col - count of columns of the matrix
     */
    public Matrix(int row, int col){
        this.matrix = new Complex[row][col];
        SetCountOfRows(row);
        SetCountOfColumns(col);
    }

    /**
     * Constructor for creating a matrix with values of given matrix
     * @param matrix - given matrix
     */
    public Matrix(Complex[][] matrix){
        this.matrix = matrix;
        SetCountOfRows(matrix.length);
        SetCountOfColumns(matrix[0].length);
    }

    /**
     * Setter to set the value of rows
     * @param rows - given value
     */
    public void SetCountOfRows(int rows){
        this.rows = rows;
    }

    /**
     * Setter to set the value of columns
     * @param columns - given value
     */
    public void SetCountOfColumns(int columns){
        this.columns = columns;
    }

    /**
     * Getter of matrix array
     * @return matrix array
     */
    public Complex[][] GetMatrix(){
        return matrix;
    }

    /**
     * Getter of count of rows of the matrix
     * @return count of rows of the matrix
     */
    public int GetCountOfRows(){
        return rows;
    }

    /**
     * Getter of count of columns of the matrix
     * @return count of columns of the matrix
     */
    public int GetCountOfColumns(){
        return columns;
    }

    /**
     * Method to get matrix elements from the user and fill the matrix with these elements
     */
    public void FillMatrix(){
        int m = this.GetCountOfRows();
        int n = this.GetCountOfColumns();
        System.out.println("Enter the elements of the matrix number by number. Enter first the real part of a complex number, then the imaginary part, separating them with a comma. If one of the parts is missing, write 0 instead.\nExample: 1.2,3.78");
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                System.out.format("Enter matrix[%d][%d]: ", i, j);
                try {
                    matrix[i][j] = InputOutput.InputAndCreateComplex();
                } catch (Exception e){
                    System.out.println("Invalid input. Try again");
                    if (i == 0 && j == 0){
                        j--;
                    } else if (j == 0){
                        j = n - 1;
                        i--;
                    } else{
                        j--;
                    }
                }
            }
        }
    }

    /**
     * Method to add two matrices
     * @param matrix2 - matrix to be added to this matrix
     * @return result of adding two matrices
     */
    public Matrix AddMatrices(Matrix matrix2){
        int m = this.GetCountOfRows();
        int n = this.GetCountOfColumns();
        Matrix result = new Matrix(m, n);
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                result.GetMatrix()[i][j] = this.matrix[i][j].Add(matrix2.GetMatrix()[i][j]);
            }
        }
        return result;
    }

    /**
     * Method to multiply two matrices
     * @param matrix2 - matrix to be multiplied by this matrix
     * @param m - count of rows of the resulting matrix
     * @param n - count of columns of the resulting matrix
     * @param l - count of columns of the first matrix
     * @return result of multiplying two matrices
     */
    public Matrix MultiplyMatrices(Matrix matrix2, int m, int n, int l){
        Matrix result = new Matrix(m, n);
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                Complex summa = new Complex();
                for (int k = 0; k < l; k++){
                    summa = summa.Add((this.matrix[i][k]).Multiply(matrix2.GetMatrix()[k][j]));
                    result.GetMatrix()[i][j] = summa;
                }
            }
        }
        return result;
    }
}
