import java.util.Scanner;

public class App {

    // both a maximum in their row and a minimum in their column
    static void peakColumns(int[][] matrix){
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // find the maximum number in the row i
                if(matrix[i][j] >= max) {
                    max = matrix[i][j];
                }
            }

            // loop through the row again and find columns where j == max
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == max) {
                    // set colMin to max and find min number in the column
                    int colMin = max;
                    for (int k = 0; k < matrix.length; k++) {
                        if(matrix[k][j] < colMin) {
                            colMin = matrix[k][j];
                        }
                    }

                    // if colMin == max then a peak column has been found
                    if(colMin == max) {
                        System.out.printf("(%s, %s) = %s \n", i + 1, j + 1, matrix[i][j]);
                    }

                    
                }
            }
            // reset value of max to first value on the next row
            if(i == matrix.length - 1) {
                max = matrix[matrix.length - 1][0];
            }
            else {
                max = matrix[i + 1][0];
            }
        }
    }
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the matrix row dimension:");
            int rowDim = -1;
            while (rowDim < 0) {
                rowDim = scanner.nextInt();
            }

            System.out.println("Enter the matrix column dimension:");
            int colDim = -1;
            while (colDim < 0) {
                colDim = scanner.nextInt();
            }

            int[][] matrix = new int[rowDim][colDim];
            System.out.println("Enter the array values row by row");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.printf("Enter a value for position (%s, %s): ", i, j);
                    matrix[i][j] = -1;
                    while (matrix[i][j] < 0) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println("\t");
            }

            
            peakColumns(matrix);
        } catch (Exception e) {
            System.out.println("Something went wrong. Try again...");
        }
    }
}
