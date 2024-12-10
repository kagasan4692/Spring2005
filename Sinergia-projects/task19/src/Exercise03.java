public class Exercise03 {
    public static void main(String[] args) {
        String string1 = "Вынослив похоже, не так ли?";
        String string2 = "Хотелось бы как-то оптимизировать?:)";
        String string3 = "Не спешите, это все возможно: мы до этого ещё дойдём!";

        String result = getLongestLine(string1, string2, string3);

        System.out.println(result);
    }

    private static String getLongestLine(String string1, String string2, String string3) {

        int[] lengthArray = new int[3];

        lengthArray[0] = string1.length();
        lengthArray[1] = string2.length();
        lengthArray[2] = string3.length();

        int max = getMaxElement(lengthArray);

        String result = " ";

        if (max == lengthArray[0]) {
            result = string1;
        } else if (max == lengthArray[1]) {
            result = string2;
        } else if (max == lengthArray[2]) {
            result = string3;
        }

        return result;
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
