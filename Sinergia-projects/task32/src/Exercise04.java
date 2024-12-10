import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату в формате dd.MM.yyyy: ");
        String inputDate = scanner.nextLine();

        LocalDate endDate = LocalDate.parse(inputDate, formatter);

        LocalDate startDate = LocalDate.of(endDate.getYear(), 1, 1);

        System.out.println("Все даты с 1 января до " + endDate.format(formatter) + ":");
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            System.out.println(date.format(formatter));
        }
    }
}
