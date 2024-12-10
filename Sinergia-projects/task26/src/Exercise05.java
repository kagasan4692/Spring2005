public class Exercise05 {
    public static void main(String[] args) {
        int lengthRow = 10, lengthCol = 20;

        int[][] myArray = createArray(lengthRow, lengthCol);

        printColArray(myArray, lengthCol - 19);

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

    private static void printColArray(int[][] array, int col) {

        int indexCol = col - 1;
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i][indexCol]);

        }
    }
}
