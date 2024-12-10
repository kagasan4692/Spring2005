public class Exercise07 {
    public static void main(String[] args) {
        int[] intArray = {159, 12, 0, -89, 205, -159, 300};
        int result = getMaxElement(intArray);

        System.out.println(result);
    }


    private static int getMaxElement(int[] array) {
        int max = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
