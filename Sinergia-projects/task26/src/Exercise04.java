public class Exercise04 {
    public static void main(String[] args) {
        int lengthRow = 10, lengthCol = 20;

        int[][] myArray = createArray(lengthRow, lengthCol);

        printRowArray(myArray, lengthRow - 1);

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

    private static void printRowArray(int[][] array, int row) {

        int indexRow = row - 1;
        for (int j = 0; j < array[indexRow].length; j++) {
            System.out.print(array[indexRow - 1][j] + ", ");

        }
    }

}
