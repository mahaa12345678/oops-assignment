package src;

import java.util.Scanner;

public class MultiplicatingMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows for matrix A: ");
        int rowsA = scanner.nextInt();

        System.out.print("Enter the number of columns for matrix A: ");
        int columnsA = scanner.nextInt();

        System.out.print("Enter the number of columns for matrix B: ");
        int columnsB = scanner.nextInt();

        int[][] matrixA = new int[rowsA][columnsA];
        int[][] matrixB = new int[columnsA][columnsB];

        System.out.println("Enter the elements of matrix A:");
        fillMatrix(scanner, matrixA);

        System.out.println("Enter the elements of matrix B:");
        fillMatrix(scanner, matrixB);

        int[][] resultMatrix = matrixMultiplication(matrixA, matrixB, rowsA, columnsA, columnsB);

       
        System.out.println("Result Matrix:");
        printMatrix(resultMatrix);
    }

    public static void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Enter element at position (" + (i + 1) + ", " + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public static int[][] matrixMultiplication(int[][] matrixA, int[][] matrixB, int rowsA, int columnsA, int columnsB) {
        int[][] resultMatrix = new int[rowsA][columnsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < columnsB; j++) {
                for (int k = 0; k < columnsA; k++) {
                    resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return resultMatrix;
    }

   
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}


