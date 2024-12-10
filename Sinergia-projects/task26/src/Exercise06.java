public class Exercise06 {
    public static void main(String[] args) {
        int tableDimensions = 9;
        int[][] myArray = createArray(tableDimensions, tableDimensions);
        printTwoDimensionalArray(myArray);
    }

    private static int[][] createArray(int lengthRow, int lengthCol) {
        int[][] array = new int[lengthRow][lengthCol];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (i + 1) * (j + 1);
            }
        }

        return array;
    }

    private static void printTwoDimensionalArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + ", ");

            }
        }
    }
}
