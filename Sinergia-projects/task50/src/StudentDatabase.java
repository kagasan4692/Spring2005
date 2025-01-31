import java.util.*;

public class StudentDatabase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, ArrayList<Integer>> studentGrades = new HashMap<>();

        while (true) {
            System.out.print("Введите имя студента (или 'exit' для выхода): ");
            String name = scanner.nextLine().trim();
            if (name.equalsIgnoreCase("exit")) {
                System.out.println("Конец программы!");
                break;
            }

            System.out.print("Введите оценку: ");
            int grade;
            try {
                grade = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите числовое значение!");
                continue;
            }

            studentGrades.putIfAbsent(name, new ArrayList<>());
            studentGrades.get(name).add(grade);

            printStudentGrades(studentGrades);
            printAverageGrade(studentGrades);
        }
        scanner.close();
    }

    private static void printStudentGrades(HashMap<String, ArrayList<Integer>> studentGrades) {
        System.out.println("\nБаза студентов:");

        for (HashMap.Entry<String, ArrayList<Integer>> entry : studentGrades.entrySet()) {
            String name = entry.getKey();
            ArrayList<Integer> grades = entry.getValue();
            double studentAverage = gradeAverage(grades);

            System.out.println(name + ": " + grades + " (Средняя: " + String.format("%.2f", studentAverage) + ")");
        }
    }

    private static double gradeAverage(ArrayList<Integer> grades){
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }

        return grades.isEmpty() ? 0 : sum / grades.size();
    }

    private static void printAverageGrade(HashMap<String, ArrayList<Integer>> studentGrades) {
        double totalSum = 0;
        int totalCount = 0;

        for (ArrayList<Integer> grades : studentGrades.values()) {
            for (int grade : grades) {
                totalSum += grade;
                totalCount++;
            }
        }

        double average = (totalCount == 0) ? 0 : totalSum / totalCount;
        System.out.println("Средняя оценка всех студентов: " + String.format("%.2f", average) + "\n");
    }


}
