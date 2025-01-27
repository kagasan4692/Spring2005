import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueWordCounter {

    public Set<String> getUniqueWordsHashSet(ArrayList<String> listWords) {
        Set<String> uniqueWords = new HashSet<>();

        for (String word : listWords) {
            uniqueWords.add(word);
        }

        return uniqueWords;
    }

    public Set<String> getUniqueWordsLinkedHashSet(ArrayList<String> listWords) {
        Set<String> uniqueWords = new LinkedHashSet<>();

        for (String word : listWords) {
            uniqueWords.add(word);
        }

        return  uniqueWords;
    }


}
