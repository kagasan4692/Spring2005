import java.util.ArrayList;
import java.util.Comparator;

public class exercise01 {
    public static void main(String[] args) {
        RandomIntList randomIntList = new RandomIntList();
        ArrayList<Integer> list1 = randomIntList.getList();
        ArrayList<Integer> list2 = randomIntList.getList();
        ArrayList<Integer> list3 = randomIntList.getList();
        ArrayList<Integer> list4 = randomIntList.getList();

        System.out.println(list1);// список случайных чисел
        list1.sort(Comparator.naturalOrder());// отсортированный по возрастанию список 1
        System.out.println(list1);
        System.out.println("--------------------------");
        System.out.println(list2);// список случайных чисел
        list2.sort(Comparator.reverseOrder());// отсортированный по убыванию список 2
        System.out.println(list2);
        System.out.println("--------------------------");
        System.out.println(list3);// список случайных чисел
        list3.sort(null);// отсортированный по возрастанию список 3
        System.out.println(list3);
        System.out.println("--------------------------");
        System.out.println(list4);// список случайных чисел
        list4.sort((o1, o2) -> Integer.compare(o2, o1));// отсортированный по убыванию список 4
        System.out.println(list4);
    }

}
