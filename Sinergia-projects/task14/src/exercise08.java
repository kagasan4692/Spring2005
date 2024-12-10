import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import java.util.Scanner;

public class exercise08 {
    public static void main(String[] args) throws IOException {
//        FileWriter writer = new FileWriter("randomWords.txt");
//        for (int i = 0; i < 1000; i++) {
//            String word = getWord();
//            writer.write(word);
//            writer.append('\n');
//            System.out.println("Слово " + (i+1) + " сохранено!");
//        }
//
//        writer.close();

        Scanner fileScanner = new Scanner(new File("randomWords.txt"));

        String[] wordsArray = new String[1000];

        for (int i = 0; i < wordsArray.length; i++) {
            String dataLine = fileScanner.nextLine();
            wordsArray[i] = dataLine;
        }

        Random random = new Random();
        int randomPosition = random.nextInt(wordsArray.length);
        String randomWord = wordsArray[randomPosition];

        char[] lettersArray = new char[randomWord.length()];
        char[] tableArray = new char[randomWord.length()];

        System.out.println("Угадай слово :");

        for (int i = 0; i < lettersArray.length; i++) {
            lettersArray[i] = randomWord.charAt(i);
            tableArray[i] = '#';
            System.out.print('#');
        }

        Scanner keyBoardScanner = new Scanner(System.in);

        int coincidence = 0;
        boolean isTrue;
        do {
            isTrue = false;
            System.out.println();
            System.out.println("Введи букву или слово целиком :");

            String letterWord = keyBoardScanner.nextLine();
            if (letterWord.length() == 1) {
                char letterChar = letterWord.charAt(0);

                for (int i = 0; i < lettersArray.length; i++) {
                    if (lettersArray[i] == letterChar) {
                        tableArray[i] = lettersArray[i];

                        coincidence = isVowelLetter(letterChar) ? coincidence + 1 : coincidence + 2;
                    }
                }

                for (int i = 0; i < tableArray.length; i++) {
                    System.out.print(tableArray[i]);
                    if (tableArray[i] == '#') {
                        isTrue = true;
                    }

                }

            } else {
                if (randomWord.equals(letterWord)) {
                    for (int i = 0; i < letterWord.length(); i++) {
                        char letterChar = letterWord.charAt(i);
                        coincidence = isVowelLetter(letterChar) ? coincidence + 1 : coincidence + 2;
                    }
                } else {
                    coincidence = coincidence -3;

                    System.out.println();
                    System.out.println("Вы не угадали слово!");
                }
            }

        } while (isTrue);

        System.out.println();
        System.out.println("Вы получаете : " + coincidence + " бал.");
    }

    private static boolean isVowelLetter(char letter) {
        char[] lettersArray = {'а', 'о', 'э', 'е', 'и', 'ы', 'у', 'ё', 'ю', 'я'};

        boolean isTrue = false;
        for (int i = 0; i < lettersArray.length; i++) {
            if (letter == lettersArray[i]) {
                isTrue = true;
            }
        }

        return isTrue;
    }

    private static String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    }

    private static String getWord() throws IOException {
        String page = downloadWebPage("https://sanstv.ru/randomWord/lang-ru/strong-2/count-1/word-%3F%3F%3F%3F%3F%3F");

        int quoteStart = page.lastIndexOf("class='strong2'") + 28;
        int quoteEnd = page.lastIndexOf("' target='_blank '");

        return page.substring(quoteStart, quoteEnd);
    }

}
