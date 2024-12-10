public class Exercise08 {
    public static void main(String[] args) {
        int[] intArray1 = {1000, 12, 0, -89, 205, -159, 300};
        int[] intArray2 = {159, 12, 0, -89, 12, -159, 300};
        int[] intArray3 = {159, 12, 0, -89, 60, -159, 650};

        int[] result = getMoreArray(intArray1, intArray2, intArray3);

        printArray(result);
    }

    private static int[] getMoreArray(int[] intArray1, int[] intArray2, int[] intArray3) {

        int sum1 = getMaxSumElementsArray(intArray1);
        int sum2 = getMaxSumElementsArray(intArray2);
        int sum3 = getMaxSumElementsArray(intArray3);


        if (sum1 > sum2) {

            if (sum1 > sum3) {
                return intArray1;
            } else {
                return intArray3;
            }

        } else {

            if (sum2 > sum3) {
                return intArray2;
            } else {
                return intArray3;
            }
        }

    }

    private static int getMaxSumElementsArray(int[] intArray) {
        int sum = 0;
        for (int i = 0; i < intArray.length; i++) {
            sum = sum + intArray[i];
        }

        return sum;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

}
