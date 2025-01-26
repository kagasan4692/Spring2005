import java.util.ArrayList;
import java.util.Comparator;

public class exercise02 {
    public static void main(String[] args) {
        RandomIntList randomIntList = new RandomIntList();
        ArrayList<Integer> list = randomIntList.getList();
        System.out.println(list);

        list.sort(new CustomComparator());
        System.out.println(list);
    }
}

class CustomComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {

        return compareNumbers(a, b);
    }

    private static int compareNumbers(Integer a, Integer b) {

        if (a % 2 == 0 && b % 2 != 0) {
            return -1;
        } else if (a % 2 != 0 && b % 2 == 0) {
            return 1;
        } else if (a % 2 == 0) {
            return a.compareTo(b);
        } else {
            return b.compareTo(a);
        }
    }
}
