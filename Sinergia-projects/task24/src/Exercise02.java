public class Exercise02 {
    public static void main(String[] args) {
        String[] array1 = {"B", "G", "Z", "S", "W"};
        String[] array2 = {"10", "2", "103", "18"};

        String[] mergedArray = mergeAlternating(array1, array2);
        for (int i = 0; i < mergedArray.length; i++) {
            System.out.print(mergedArray[i] + " ");
        }
    }

    public static String[] mergeAlternating(String[] array1, String[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;
        int maxLength = Math.max(length1, length2);
        String[] result = new String[length1 + length2];

        int index = 0;
        for (int i = 0; i < maxLength; i++) {
            if (i < length1) {
                result[index++] = array1[i];
            }
            if (i < length2) {
                result[index++] = array2[i];
            }
        }

        return result;
    }
}
