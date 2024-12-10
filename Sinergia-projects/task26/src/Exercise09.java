public class Exercise09 {
    public static void main(String[] args) {

        char[][] abcArray = createArray();
        printTwoDimensionalArray(abcArray);

    }

    private static char[][] createArray() {
        char[][] array = new char[3][11];

        char letterChar = 'а';

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (letterChar > 'я') {
                    array[i][j] = ' ';
                } else {
                    array[i][j] = letterChar;
                    letterChar++;
                }

            }
        }

        return array;
    }

    private static void printTwoDimensionalArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {
                if (i == array.length - 1 && j == array[i].length - 1) {
                    System.out.print(array[i][j]);
                } else {
                    System.out.print(array[i][j] + ", ");
                }


            }
        }
    }
}
