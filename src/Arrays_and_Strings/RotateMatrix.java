package Arrays_and_Strings;

import CtCILibrary.*;

/*
Try thinking about it layer by layer. Can you rotate a specific layer?

Rotating a specific layer would just mean swapping the values in four arrays.
If you were asked to swap the values in two arrays, could you do this?
Can you then extend it to four arrays?
 */
public class RotateMatrix {

//    public static boolean rotate(int[][] matrix) {
//        if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
//        int n = matrix.length;
//
//        for (int layer = 0; layer < n / 2; layer++) {
//            int first = layer;
//            int last = n - 1 - layer;
//            for(int i = first; i < last; i++) {
//                int offset = i - first;
//                int top = matrix[first][i]; // save top
//
//                // left -> top
//                matrix[first][i] = matrix[last-offset][first];
//
//                // bottom -> left
//                matrix[last-offset][first] = matrix[last][last - offset];
//
//                // right -> bottom
//                matrix[last][last - offset] = matrix[i][last];
//
//                // top -> right
//                matrix[i][last] = top; // right <- saved top
//            }
//        }
//        return true;
//    }

    public static boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }

        int n = matrix[0].length;
        // reverse upside down
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }

        // reverse symmetric
        for (int i = 0; i < n; i++) {
            // watch out here, j start as i
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        return true;
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
    public static void main(String[] args) {
        int[][] matrix = AssortedMethods.randomMatrix(3, 3, 0, 9);

//        matrix.length == number of rows, since column may different
//        System.out.println(matrix.length);

        AssortedMethods.printMatrix(matrix);
        rotate(matrix);
        System.out.println();
        AssortedMethods.printMatrix(matrix);
    }
}
