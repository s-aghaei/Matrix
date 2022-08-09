package Matrix;

import java.util.Date;
import java.util.Scanner;

public class MatrixMultiplication {


    public static void main(String[] args) {

        Date start = new Date();

        int[][] m1 = MatrixGeneratorUtil.generateMatrix(4, 3);
        int[][] m2 = MatrixGeneratorUtil.generateMatrix(3, 4);

        int[][] result = new int[m1.length][m2[0].length];
        ParallelThreadsCreator.multiply(m1, m2, result);

        System.out.println("Matrix 1 : ");
        MatrixGeneratorUtil.print(m1);

        System.out.println("\nMatrix 2 : ");
        MatrixGeneratorUtil.print(m2);

        System.out.println("\nOutput Matrix : ");
        MatrixGeneratorUtil.print(result);


        Date end = new Date();
        System.out.println("\nTime taken in milli seconds: " + (end.getTime() - start.getTime()));

    }
}



