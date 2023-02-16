/**
 * Class of matrices
 * @author Julia Komarova
 */
public class Matrix {
    private final Complex[][] matrix;
    private int rows, columns;

    /**
     *
     * @param row
     * @param col
     */
    public Matrix(int row, int col){
        this.matrix = new Complex[row][col];
        SetCountOfRows(row);
        SetCountOfColumns(col);
    }
    public Matrix(Complex[][] matrix){
        this.matrix = matrix;
        SetCountOfRows(matrix.length);
        SetCountOfColumns(matrix[0].length);
    }
    public void SetCountOfRows(int rows){
        this.rows = rows;
    }
    public void SetCountOfColumns(int columns){
        this.columns = columns;
    }
    /**
     *
     * @return
     */
    public Complex[][] GetMatrix(){
        return matrix;
    }
    public int GetCountOfRows(){
        return rows;
    }
    public int GetCountOfColumns(){
        return columns;
    }
    public static Complex[][] AddMatrices(Complex[][] matrix1, Complex[][] matrix2, int m, int n){
        Complex[][] result = new Complex[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                result[i][j] = Complex.Add(matrix1[i][j], matrix2[i][j]);
            }
        }
        return result;
    }
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
