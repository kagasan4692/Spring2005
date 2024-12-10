public class Exercise04 {
    public static void main(String[] args) {
        String[] words = {
                "ПрИвЕт",
                "мир",
                "ЗаБоРчИкОм",
                "СлОвО",
                "СтРоКа",
                "пандус",
                "КаЛаМбУр",
                "Зерно"
        };

        String lastMixedCaseWord = null;

        for (int i = 0; i < words.length; i++) {
            if (isMixedCase(words[i])) {
                lastMixedCaseWord = words[i];
            }
        }


        if (lastMixedCaseWord != null) {
            System.out.println("Последнее слово с чередованием регистра: " + lastMixedCaseWord);
        } else {
            System.out.println("В массиве нет слов с чередованием регистра.");
        }
    }

    private static boolean isMixedCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if ((i % 2 == 0 && !Character.isUpperCase(letter)) ||
                    (i % 2 != 0 && Character.isUpperCase(letter))) {
                return false;
            }
        }
        return true;
    }
}
