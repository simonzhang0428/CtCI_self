package Arrays_and_Strings;

import CtCILibrary.AssortedMethods;

/*
If you just cleared the rows and columns as you found Os, you'd likely wind up clearing the whole matrix.
Try finding the cells with zeros first before making any changes to the matrix.

Can you use O(N) additional space instead of O(N2)?
What information do you really need from the list of cells that are zero?

You probably need some data storage to maintain a list of the rows and columns that need to be zeroed.
Can you reduce the additional space usage to 0(1) by using the matrix itself for data storage?
 */
public class ZeroMatrix {
    public static void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    row[r] = true;
                    col[c] = true;
                }
            }
        }

        // nullify rows
        for (int r = 0; r < matrix.length; r++) {
            if (row[r]) {
                nullifyRow(matrix, r);
            }
        }

        // nullify column
        for (int c = 0; c < matrix[0].length; c++) {
            if (col[c]) {
                nullifyCol(matrix, c);
            }
        }
    }

    public static void nullifyRow(int[][] matrix, int r) {
        for (int c = 0; c < matrix[0].length; c++) {
            matrix[r][c] = 0;
        }
    }

    public static void nullifyCol(int[][] matrix, int c) {
        for (int r = 0; r < matrix.length; r++) {
            matrix[r][c] = 0;
        }
    }

    public static void main(String[] args) {
        int nrows = 6;
        int ncols = 4;
        int[][] matrix = AssortedMethods.randomMatrix(nrows, ncols, -5, 5);

        AssortedMethods.printMatrix(matrix);

        setZeros(matrix);

        System.out.println();

        AssortedMethods.printMatrix(matrix);
    }
}
