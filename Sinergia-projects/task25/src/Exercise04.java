import java.util.Arrays;

public class Exercise04 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int[] array3 = {7, 8, 9};
        int[] array4 = {10, 11, 12};

        System.out.println("Результат для двух массивов: " + Arrays.toString(merge2(array1, array2)));
        System.out.println("Результат для трёх массивов: " + Arrays.toString(merge3(array1, array2, array3)));
        System.out.println("Результат для четырёх массивов: " + Arrays.toString(merge4(array1, array2, array3, array4)));
    }

    public static int[] merge2(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, result, 0, array1.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }

    public static int[] merge3(int[] array1, int[] array2, int[] array3) {
        int[] result = new int[array1.length + array2.length + array3.length];
        System.arraycopy(array1, 0, result, 0, array1.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        System.arraycopy(array3, 0, result, array1.length + array2.length, array3.length);
        return result;
    }


    public static int[] merge4(int[] array1, int[] array2, int[] array3, int[] array4) {
        int[] result = new int[array1.length + array2.length + array3.length + array4.length];
        System.arraycopy(array1, 0, result, 0, array1.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        System.arraycopy(array3, 0, result, array1.length + array2.length, array3.length);
        System.arraycopy(array4, 0, result, array1.length + array2.length + array3.length, array4.length);
        return result;
    }
}
