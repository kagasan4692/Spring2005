public class Exercise05 {
    public static void main(String[] args) {
        String[] string = new String[10];

        printArray(string);

    }

    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
