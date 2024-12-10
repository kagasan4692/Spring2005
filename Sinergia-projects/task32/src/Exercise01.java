import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Exercise01 {
    public static void main(String[] args) {
        printAllDatesOfCurrentYear();
    }

    public static void printAllDatesOfCurrentYear() {

        int currentYear = LocalDate.now().getYear();

        LocalDate startOfYear = LocalDate.of(currentYear, 1, 1);
        LocalDate endOfYear = LocalDate.of(currentYear, 12, 31);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate currentDate = startOfYear;
        while (!currentDate.isAfter(endOfYear)) {

            System.out.println(currentDate.format(outputFormatter));

            currentDate = currentDate.plusDays(1);
        }
    }

}
