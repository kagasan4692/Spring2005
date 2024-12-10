public class Exercise06 {
    public static void main(String[] args) {
        String string = "Не спешите, это все возможно: мы до этого ещё дойдём!";

        char[] symbolArray = toAlternatingCase(string);

        printCharArray(symbolArray);
    }

    private static char[] toAlternatingCase(String string) {
        char[] result = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            char symbol = string.charAt(i);
            if (i % 2 == 0) {
                result[i] = Character.toUpperCase(symbol);
            } else {
                result[i] = Character.toLowerCase(symbol);
            }
        }

        return result;
    }

    private static void printCharArray(char[] symbolArray){
        for (int i = 0; i < symbolArray.length; i++) {
            System.out.print(symbolArray[i]);
        }
    }

}
