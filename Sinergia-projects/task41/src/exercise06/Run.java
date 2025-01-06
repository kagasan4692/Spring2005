package exercise06;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        while (true){
            System.out.println("Введите нужный формат вывода в консоль");
            System.out.print("XML или JSON: ");
            String format = scanner.nextLine();
            if (format.equals("XML") || format.equals("JSON")){
                ITunesSong.run("JSON");
                break;
            } else {
                System.out.println("Неверный ввод!");
            }
        }


    }
}
