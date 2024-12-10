public class Exercise03 {
    public static void main(String[] args) {
        int lengthRow = 10, lengthCol = 20;

        int[][] myArray = createArray(lengthRow, lengthCol);

        printTwoDimensionalArray(myArray);

    }

    private static int[][] createArray(int lengthRow, int lengthCol) {
        int[][] array = new int[lengthRow][lengthCol];

        int value = 10;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = value;
                value = value + 2;
            }
        }

        return array;
    }

    private static void printTwoDimensionalArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println();
//            System.out.print("{");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + ", ");

            }
//            System.out.print("}");
        }
    }
}
