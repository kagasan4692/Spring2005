package Exercise07;

import java.util.Scanner;

public class TextChecker {
    private String text;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите любую строку и проверьте ее на подмену похожих символов:");
        String string = scanner.nextLine();

//        String string = "Проверка текста на наличие инностранных буkв вместо русской раскладки и цифр вместо...";

        try {
            TextChecker checker = new TextChecker(string);

            System.out.println("Текст прошел проверку: " + checker.getText());
        } catch (InvalidCharacterException e) {
            System.err.println("Ошибка проверки текста: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Некорректный текст: " + e.getMessage());
        }
    }

    public TextChecker(String text) throws InvalidCharacterException {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст не может быть пустым или null.");
        }
        this.text = text;
        validateText(this.text);
    }

    private void validateText(String text) throws InvalidCharacterException {
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (isLetters(ch) || isDigit(ch)) {
                throw new InvalidCharacterException("Обнаружена подмена символа: " + ch);
            }
        }
    }

    private boolean isLetters(char ch) {
        return (ch == 'A' || ch == 'a' || ch == 'B' || ch == 'b' ||
                ch == 'C' || ch == 'c' || ch == 'E' || ch == 'e' ||
                ch == 'H' || ch == 'h' || ch == 'K' || ch == 'k' ||
                ch == 'M' || ch == 'm' || ch == 'O' || ch == 'o' ||
                ch == 'P' || ch == 'p' || ch == 'T' || ch == 't' ||
                ch == 'X' || ch == 'x' || ch == 'Y' || ch == 'y');
    }

    private boolean isDigit(char ch) {
        return (ch == '0' || ch == '3');
    }

    public String getText() {
        return text;
    }

    public static class InvalidCharacterException extends Exception {
        public InvalidCharacterException(String message) {
            super(message);
        }
    }
}
