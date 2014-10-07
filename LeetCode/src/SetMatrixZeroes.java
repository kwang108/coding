/**
 * Created by kkwang on 9/5/2014.
 */
public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        boolean hasFirstRowZero = false, hasFirstColZero = false;

        for(int c = 0; c < matrix[0].length; c++) {
            if(matrix[0][c] == 0) {
                hasFirstRowZero = true;
                break;
            }
        }
        for(int r = 0; r < matrix.length; r++) {
            if(matrix[r][0] == 0) {
                hasFirstColZero = true;
                break;
            }
        }
        //If a cell is 0, store 0 in the first row and first column corresponding to the cell
        for(int r = 1; r < matrix.length; r++) {
            for(int c = 1; c < matrix[0].length; c++) {
                if(matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }
        for(int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                if(matrix[0][c] == 0 || matrix[r][0] == 0)
                    matrix[r][c] = 0;
            }
        }
        if(hasFirstRowZero) {
            for(int c = 0; c < matrix[0].length; c++) matrix[0][c] = 0;
        }
        if(hasFirstColZero) {
            for(int r = 0; r < matrix.length; r++) matrix[r][0] = 0;
        }
    }
}
