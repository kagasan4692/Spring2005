import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Exercise03 {
    public static void main(String[] args) {

        ZonedDateTime departureTime = ZonedDateTime.of(
                LocalDateTime.of(2020, 1, 1, 12, 0),
                ZoneId.of("Europe/Moscow")
        );

        ZonedDateTime arrivalTime = departureTime
                .plusHours(10)
                .plusMinutes(15)
                .withZoneSameInstant(ZoneId.of("Asia/Vladivostok"));

        System.out.println("Время вылета (Москва): " + dateFormater(departureTime));
        System.out.println("Время прибытия (Владивосток): " + dateFormater(arrivalTime));
    }

    public static String dateFormater(ZonedDateTime zonedDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        zonedDateTime.format(formatter);

        return zonedDateTime.format(formatter);
    }
}
