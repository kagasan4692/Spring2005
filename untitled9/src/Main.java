import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> people = new ArrayList<String>();
        people.add("Tom");
        people.add("Alice");
        people.add("Santa");
//        people.remove(0);
//        people.remove("Santa");
//        people.remove(0);
        System.out.println(people.set(0, "Valera"));

//        System.out.println(people.subList(0, 3));

//        if (people.size() == 0) {
//            System.out.println("Noooo!");
//        } else {
//            for (String person : people.subList(0, 3)) {
//                System.out.println(person);
//            }
//        }

    }


}