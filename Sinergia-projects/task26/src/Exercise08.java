public class Exercise08 {
    public static void main(String[] args) {

        char[][] abcArray = createArray();
        printTwoDimensionalArray(abcArray);

    }

    private static char[][] createArray() {
        char[][] array = new char[2][13];

        char letterChar = 'a';

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = letterChar;
                letterChar++;
            }
        }

        return array;
    }

    private static void printTwoDimensionalArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + ", ");

            }
        }
    }
}
