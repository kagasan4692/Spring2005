public class Exercise05 {
    public static void main(String[] args) {
        String string1 = "Вынослив похоже, не так ли?";
        String string2 = "Хотелось бы как-то оптимизировать?:)";
        String string3 = "Не спешите, это все возможно: мы до этого ещё дойдём!";
        String string4 = "Напишите метод, который возвращает самую длинную из четырех строк.";
        String string5 = "Напишите метод, который возвращает самую длинную из пяти строк.";

        String result = getLongestLine(string1, string2, string3, string4, string5);

        System.out.println(result);
    }

    private static String getLongestLine(String string1, String string2, String string3, String string4, String string5) {
        int length1 = string1.length();
        int length2 = string2.length();
        int length3 = string3.length();
        int length4 = string4.length();
        int length5 = string5.length();

        int max = greaterNumberOfFour(length1, length2, length3, length4, length5);

        String result = " ";

        if (max == length1) {
            result = string1;
        } else if (max == length2) {
            result = string2;
        } else if (max == length3) {
            result = string3;
        } else if (max == length4) {
            result = string4;
        } else if (max == length5) {
            result = string5;
        }

        return result;
    }

    private static int greaterNumberOfFour(int a, int b, int c, int d, int e) {
        int max = Math.max(a, b);
        max = Math.max(max, c);
        max = Math.max(max, d);
        max = Math.max(max, e);

        return max;
    }
}
