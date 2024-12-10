import java.time.LocalDate;

public class Exercise07 {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Сегодняшняя дата: " + currentDate);

        int[][] calendar = createArray(currentDate);
//        printTwoDimensionalArray(calendar);
        printCalendar(calendar);

    }

    private static int[][] createArray(LocalDate currentDate) {

        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);


        int startDay = firstDayOfMonth.getDayOfWeek().getValue();

        int daysInMonth = currentDate.lengthOfMonth();

        int[][] array = new int[6][7];

        int dayCounter = 1;
        for (int week = 0; week < array.length; week++) {
            for (int day = 0; day < 7; day++) {

                if (week == 0 && day < startDay - 1 || dayCounter > daysInMonth) {
                    array[week][day] = 0;
                } else {
                    array[week][day] = dayCounter;
                    dayCounter++;
                }
            }
        }

        return array;
    }

    private static void printCalendar(int[][] array) {
        System.out.println(" пн вт ср чт пт сб вс");

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    System.out.print("   ");
                } else {
                    if (array[i][j] < 10){
                        System.out.print("  " + array[i][j]);
                    } else {
                        System.out.print(" " + array[i][j]);
                    }

                }
            }
            System.out.println();
        }

    }
}

