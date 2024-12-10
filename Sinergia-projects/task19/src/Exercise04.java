public class Exercise04 {
    public static void main(String[] args) {
        String string1 = "Вынослив похоже, не так ли?";
        String string2 = "Хотелось бы как-то оптимизировать?:)";
        String string3 = "Не спешите, это все возможно: мы до этого ещё дойдём!";
        String string4 = "Напишите метод, который возвращает самую длинную из четырех строк.";

        String result = getLongestLine(string1, string2, string3, string4);

        System.out.println(result);
    }

    private static String getLongestLine(String string1, String string2, String string3, String string4) {
        int[] lengthArray = new int[4];

        lengthArray[0] = string1.length();
        lengthArray[1] = string2.length();
        lengthArray[2] = string3.length();
        lengthArray[3] = string4.length();

        int max = getMaxElement(lengthArray);

        String result = " ";

        if (max == lengthArray[0]) {
            result = string1;
        } else if (max == lengthArray[1]) {
            result = string2;
        } else if (max == lengthArray[2]) {
            result = string3;
        } else if (max == lengthArray[3]) {
            result = string4;
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
