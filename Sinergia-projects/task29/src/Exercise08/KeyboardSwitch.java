package Exercise08;

public class KeyboardSwitch {
    private String text;

    private static final char[] ruKeys = {
            'й', 'ц', 'у', 'к', 'е', 'н', 'г', 'ш', 'щ', 'з', 'х', 'ъ',
            'ф', 'ы', 'в', 'а', 'п', 'р', 'о', 'л', 'д', 'ж', 'э',
            'я', 'ч', 'с', 'м', 'и', 'т', 'ь', 'б', 'ю'
    };

    private static final char[] enKeys = {
            'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', '[', ']',
            'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';', '\'',
            'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.'
    };

    public static void main(String[] args) {
        try {
            KeyboardSwitch switcher1 = new KeyboardSwitch("Rhjrjlbk lbk lbk gksdtn!");
            System.out.println("Преобразованный текст: " + switcher1.getText());

            KeyboardSwitch switcher2 = new KeyboardSwitch("Пщ рщьу!");
            System.out.println("Преобразованный текст: " + switcher2.getText());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public KeyboardSwitch(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст не может быть пустым или null.");
        }
        this.text = autoSwitchLanguage(text);
    }

    private String autoSwitchLanguage(String text) {
        int ruCount = 0, enCount = 0;

        for (char ch : text.toCharArray()) {
            if (findIndex(ruKeys, ch) != -1) {
                ruCount++;
            } else if (findIndex(enKeys, ch) != -1) {
                enCount++;
            }
        }

        if (ruCount > enCount) {
            return switchToEnglish(text);
        }

        return switchToRussian(text);
    }

    private String switchToEnglish(String text) {
        StringBuilder result = new StringBuilder();
        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int index = findIndex(ruKeys, ch);
            if (index != -1) {
                result.append(enKeys[index]);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    private String switchToRussian(String text) {
        StringBuilder result = new StringBuilder();
        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int index = findIndex(enKeys, ch);
            if (index != -1) {
                result.append(ruKeys[index]);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    private int findIndex(char[] array, char ch) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ch || Character.toUpperCase(array[i]) == Character.toUpperCase(ch)) {
                return i;
            }
        }
        return -1;
    }

    public String getText() {
        return text;
    }
}
