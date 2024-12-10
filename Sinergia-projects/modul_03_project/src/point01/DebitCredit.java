package point01;

import java.util.Scanner;

public class DebitCredit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String transaction = getTransaction(scanner);
        System.out.println(transaction);

        String typeTransaction = getTypeTransaction(scanner);
        System.out.println(typeTransaction);
    }

    public static String getTransaction(Scanner scanner) {
        System.out.print("Введите описание сделки: ");

        return scanner.nextLine();
    }

    public static String getTypeTransaction(Scanner scanner) {
        System.out.println("Выберете тип сделки: ");
        String result =" ";
        do {
            if (result.equals("false")) {
                System.out.println("Неверный ввод!");
                System.out.println("Выберете тип сделки заново: ");
            }
            System.out.print("1 - Расход, 2 -Доход: ");
            int debitOrCredit = scanner.nextInt();

            switch (debitOrCredit) {
                case 1:
                    result = "Расход";
                    break;
                case 2:
                    result = "Доход";
                    break;
                default:
                    result = "false";
            }
        } while (result.equals("false"));


        return result;
    }

}
