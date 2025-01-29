import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueWordCounter {

    public HashSet<String> getUniqueWordsHashSet(ArrayList<String> listWords) {
        HashSet<String> uniqueWords = new HashSet<>();

        for (String word : listWords) {
            uniqueWords.add(word);
        }

        return uniqueWords;
    }

    public LinkedHashSet<String> getUniqueWordsLinkedHashSet(ArrayList<String> listWords) {
        LinkedHashSet<String> uniqueWords = new LinkedHashSet<>();

        for (String word : listWords) {
            uniqueWords.add(word);
        }

        return  uniqueWords;
    }


}
