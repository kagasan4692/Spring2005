import java.util.Scanner;

public class Exercise01 {
    private static final char[] vowels = {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я', 'А', 'Е', 'Ё', 'И', 'О', 'У', 'Ы', 'Э', 'Ю', 'Я'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ввод 10 слов для массива");
        String[] newArray = new String[10];

        for (int i = 0; i < newArray.length; i++) {
            System.out.println("Введите слово №" + (i + 1));
            newArray[i] = scanner.nextLine();
        }

        String result = "В введенных словах двух гласных подряд не встречается";
        for (int i = 0; i < newArray.length; i++) {
            if (isVowelCoincidence(newArray[i])) {
                result = "Первое слово с двумя гласными подряд: " + newArray[i];
                break;
            }
        }

        System.out.println(result);
    }

    private static boolean isTwoVowels(String wordVowelReplacement) {

        boolean isVowels = false;
        boolean isCoincidence = false;

        for (int i = 0; i < wordVowelReplacement.length(); i++) {
            if (!isVowels && wordVowelReplacement.charAt(i) == '*') {
                isVowels = true;

            } else if (isVowels && wordVowelReplacement.charAt(i) == '*') {
                isCoincidence = true;
                break;

            } else {
                isVowels = false;
            }

        }

        return isCoincidence;
    }

    private static boolean isVowelCoincidence(String word) {
        StringBuilder wordBuilder = new StringBuilder(word);

        for (int i = 0; i < wordBuilder.length(); i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (wordBuilder.charAt(i) == vowels[j]) {
                    wordBuilder.replace(i, i + 1, "*");
                }
            }
        }


        return isTwoVowels(wordBuilder.toString());
    }


}
