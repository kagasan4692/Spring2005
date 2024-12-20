package point01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RunTxt {

    public static final String notDataInfo = "Файл не содержит инфрмации, или отсутсвует!";
    public static final String createListInfo = "Хотите создать новый список транзакций?";
    public static final String yesNoInfo = "Если ДА то введите 1, Если НЕТ то введите 2.";
    public static final String selectOutputTypeInfo = "Хотите посмотреть весь список? Или отчет по месяцам?";
    public static final String yesNoListInfo = "Список транзакций - 1, Отчет по месяцам 2.";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filePathTxt = "transactions.txt";
        TxtFileHandler txtHandler = new TxtFileHandler(filePathTxt);

        if (fileChecker(filePathTxt)) {
            System.out.println(selectOutputTypeInfo);
            System.out.println(yesNoListInfo);
            if (checkEnteredInt(scanner)) {
                System.out.println("Грузим список!");
            } else {
                System.out.println("Работаем по месяцам!");
            }
        } else {
            System.out.println(notDataInfo);
            System.out.println(createListInfo);
            System.out.println(yesNoInfo);

            if (checkEnteredInt(scanner)) {
                txtHandler.runTxt();
            } else {
                System.out.println("выходим из программы!");
            }
        }

    }

    private static boolean fileChecker(String filePath) {
        File file = new File(filePath);

        return (file.exists() && file.length() > 0);
    }

    private static boolean checkEnteredInt(Scanner scanner) {
        while (true) {

            int value;
            try {
                value = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                value = 0;
            }

            switch (value) {
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    System.out.println("Неверный ввод!");
                    System.out.println("Введите информацию заново: ");
                    System.out.println(createListInfo);
                    System.out.println(yesNoInfo);
            }
        }

    }

}
