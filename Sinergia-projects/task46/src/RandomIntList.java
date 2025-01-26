import java.util.ArrayList;
import java.util.Random;

public class RandomIntList {
    public static ArrayList<Integer> getList () {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100));
        }

        return numbers;
    }
}
