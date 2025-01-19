package exercise01;

import java.util.Scanner;

public class run {
    public static void main(String[] args) {
        BaseConverter kelvinConverter = new CelsiusToKelvinConverter();
        BaseConverter fahrenheitConverter = new CelsiusToFahrenheitConverter();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите температуру в Цельсиях (например, 25,55): ");
        double celsiusTemperature = scanner.nextDouble();

        System.out.println("Температура в Цельсиях: " + celsiusTemperature);
        System.out.println("Температура в Кельвинах: " + kelvinConverter.convert(celsiusTemperature));
        System.out.println("Температура в Фаренгейтах: " + fahrenheitConverter.convert(celsiusTemperature));
    }
}
