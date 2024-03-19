package Exer02;

import java.util.Random;

public class controller {
 public static void main(String[] args) {
     int[][] matrix = generateRandomMatrix(3, 5);

     for (int i = 0; i < matrix.length; i++) {
         Th02 thread = new Th02(matrix[i], i + 1);
         thread.start();
     }
 }

 private static int[][] generateRandomMatrix(int rows, int cols) {
     int[][] matrix = new int[rows][cols];
     Random rand = new Random();

     for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
             matrix[i][j] = rand.nextInt(100);
         }
     }

     return matrix;
 }
}
