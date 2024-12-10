public class Exercise09 {
    public static void main(String[] args) {
        int[] intArray = {159, 12, 0, -89, 60, -159, 650};

        int[] result = getPositiveArray(intArray);

        printArray(result);
    }

    private static int[] getPositiveArray(int[] array) {
        int[] positiveArray = new int[getLengthPositiveArray(array)];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                positiveArray[j] = array[i];
                j++;
            }
        }

        return positiveArray;
    }

    private static int getLengthPositiveArray(int[] array) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                j++;
            }
        }

        return j;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
