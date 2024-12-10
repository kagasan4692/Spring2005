import java.time.LocalDate;

public class Exercise02 {
    final static String[] monthNames = {
            "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
            "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
    };

    final static int year = 2024;

    public static void main(String[] args) {
        for (int i = 1; i <= 12; i++) {
            drawCalendar(year, i);
            System.out.println();
            System.out.println();
        }
    }

    public static void drawCalendar(int year, int month) {

        String monthName = monthNames[month - 1];
        System.out.println(monthName.toUpperCase());

        System.out.println("пн вт ср чт пт сб вс");

        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        int lengthOfMonth = firstDayOfMonth.lengthOfMonth();

        int startDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue();

        int day = 1;
        int i = 0;
        do {
            i++;
            if (i < startDayOfWeek) {
                System.out.print("   ");
            } else if (day < 10) {
                System.out.print(day + "  ");
                day++;
            } else if (day >= 10) {
                System.out.print(day + " ");
                day++;
            }

            if ((startDayOfWeek + day - 2) % 7 == 0) {
                System.out.println();
            }

        } while (day != lengthOfMonth + 1);
    }

    public static void getEveryMonth() {

    }
}
