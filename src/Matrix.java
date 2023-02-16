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
     * Method to add two matrices
     * @param matrix1 - first matrix
     * @param matrix2 - second matrix
     * @param m - count of rows of the resulting matrix
     * @param n - count of columns of the resulting matrix
     * @return result of adding two matrices
     */
    public static Complex[][] AddMatrices(Complex[][] matrix1, Complex[][] matrix2, int m, int n){
        Complex[][] result = new Complex[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                result[i][j] = Complex.Add(matrix1[i][j], matrix2[i][j]);
            }
        }
        return result;
    }

    /**
     * Method to multiply two matrices
     * @param matrix1 - first matrix
     * @param matrix2 - second matrix
     * @param m - count of rows of the resulting matrix
     * @param n - count of columns of the resulting matrix
     * @param l - count of columns of the first matrix
     * @return result of multiplying two matrices
     */
    public static Complex[][] MultiplyMatrices(Complex[][] matrix1, Complex[][] matrix2, int m, int n, int l){
        Complex[][] result = new Complex[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                Complex summa = new Complex();
                for (int k = 0; k < l; k++){
                    summa = Complex.Add(summa, Complex.Multiply(matrix1[i][k], matrix2[k][j]));
                    result[i][j] = summa;
                }
            }
        }
        return result;
    }
}
