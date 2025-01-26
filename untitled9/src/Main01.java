import java.util.*;

public class Main01 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int newNumber = scanner.nextInt();
            numbers.add(newNumber);
            System.out.println(numbers);
//            Collections.sort(numbers);
            numbers.sort(Comparator.comparingInt(a->a));
            System.out.println(numbers);
        }
    }
}
