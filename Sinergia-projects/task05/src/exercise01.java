import java.util.Scanner;

public class exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите основание степени:");
        double basisDegree = scanner.nextDouble();

        System.out.println("Введите степень:");
        double degree = scanner.nextInt();

        System.out.println("Результат:");
        double result = Math.pow(basisDegree, degree);
        System.out.println(result);
    }
}
