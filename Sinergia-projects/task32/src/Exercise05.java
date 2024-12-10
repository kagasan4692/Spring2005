import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите исходный часовой пояс (например, Europe/Moscow): ");
        String departureZone = scanner.nextLine();

        System.out.print("Введите часовой пояс назначения (например, Asia/Vladivostok): ");
        String arrivalZone = scanner.nextLine();

        System.out.print("Введите дату и время вылета (в формате dd.MM.yyyy HH:mm): ");
        String departureTimeInput = scanner.nextLine();

        System.out.print("Введите длительность полета (часы): ");
        int flightHours = scanner.nextInt();

        System.out.print("Введите длительность полета (минуты): ");
        int flightMinutes = scanner.nextInt();

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime localDepartureTime = LocalDateTime.parse(departureTimeInput, inputFormatter);

        ZonedDateTime departureTime = ZonedDateTime.of(localDepartureTime, ZoneId.of(departureZone));

        ZonedDateTime arrivalTime = departureTime
                .plusHours(flightHours)
                .plusMinutes(flightMinutes)
                .withZoneSameInstant(ZoneId.of(arrivalZone));
        System.out.println();
        System.out.println("Время вылета (местное): " + dateFormater(departureTime));
        System.out.println("Местное время прилета: " + dateFormater(arrivalTime));
    }

    public static String dateFormater(ZonedDateTime zonedDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        zonedDateTime.format(formatter);

        return zonedDateTime.format(formatter);
    }
}
