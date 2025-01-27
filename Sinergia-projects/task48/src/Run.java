import java.io.IOException;
import java.util.ArrayList;

public class Run {
    public static void main(String[] args) throws IOException {
        WordCounter arrayListWords = new WordCounter();
        ArrayList<String> listWords = arrayListWords.getListWords();
        System.out.print("Всего слов в документе: ");
        int totalWords = listWords.size();
        System.out.println(totalWords);
        separator();

        UniqueWordCounter uniqueWordCounter1 = new UniqueWordCounter();
        System.out.print("Кол-во уникальных слов в документе (HashSet): ");
        int uniqueWords1 = uniqueWordCounter1.getUniqueWordsHashSet(listWords).size();
        System.out.println(uniqueWords1);
        System.out.print("Процент повторяемости слов: ");
        System.out.println(calculateRepetitionPercentage(totalWords, uniqueWords1));
        separator();

        UniqueWordCounter uniqueWordCounter2 = new UniqueWordCounter();
        System.out.print("Кол-во уникальных слов в документе (LinkedHashSet): ");
        int uniqueWords2 = uniqueWordCounter2.getUniqueWordsLinkedHashSet(listWords).size();
        System.out.println(uniqueWords2);
        System.out.print("Процент повторяемости слов: ");
        System.out.println(calculateRepetitionPercentage(totalWords, uniqueWords2));
        separator();

    }

    private static void separator() {
        System.out.println("---------------------------------");
    }

    private static String calculateRepetitionPercentage(int totalWords, int uniqueWords) {
        if (totalWords == 0) {
            throw new IllegalArgumentException("Общее количество слов не может быть равно нулю.");
        }
        double percentage = (1 - ((double) uniqueWords / totalWords)) * 100;

        return String.format("%.2f", percentage) + "%";
    }
}
