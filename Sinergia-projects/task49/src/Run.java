import java.util.TreeSet;

public class Run {
    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>(new gradeComparator());

        students.add(new Student("Иван", 20));
        students.add(new Student("Анна", 19));
        students.add(new Student("Сергей", 21));
        students.add(new Student("Екатерина", 18));
        students.add(new Student("Сергей", 21));

        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
