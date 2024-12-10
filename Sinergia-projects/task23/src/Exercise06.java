public class Exercise06 {
    public static void main(String[] args) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String[] monthNames = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

        for (int month = 0; month < 12; month++) {
            for (int day = 1; day <= daysInMonths[month]; day++) {
                System.out.println(day + " " + monthNames[month]);
            }
        }
    }
}
