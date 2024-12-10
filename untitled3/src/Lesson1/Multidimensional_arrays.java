package Lesson1;

public class Multidimensional_arrays {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        System.out.println(numbers[1]);

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9, 15}
        };
        System.out.println(matrix[2][3]);

        String[][] strings = new String[2][3];

        strings[0][1] = "Привет";
        System.out.println(strings[0][1]);

        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(matrix1.length);

        for (int p = 0; p < matrix1.length; p++) {
            for (int i = 0; i < matrix1[p].length; i++) {
                System.out.print(matrix1[p][i] + "");
            }
            System.out.println();
        }
//        for (int p = 0; p < matrix1.length; p++) {
//            for (row:
//                 matrix1[p]) {
//                System.out.println(matrix1[p][row]);
//            }
//        }
    }

}
