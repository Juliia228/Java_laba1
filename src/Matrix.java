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
}
