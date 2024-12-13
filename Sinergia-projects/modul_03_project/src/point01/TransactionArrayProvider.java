package point01;

public class TransactionArrayProvider {
    public static String[] createDataArray(String input){
        String[] substrings = new String[countClosingBraces(input)];
        int count = 0;

        int startIndex = 0;
        while ((startIndex = input.indexOf('{', startIndex)) != -1) {
            int endIndex = input.indexOf('}', startIndex);
            if (endIndex == -1) {
                break;
            }

            String substring = input.substring(startIndex + 1, endIndex);
            substrings[count++] = substring;

            startIndex = endIndex + 1;
        }

        return substrings;
    }

    public static int countClosingBraces(String input) {
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '}') {
                count++;
            }
        }

        return count;
    }
}
