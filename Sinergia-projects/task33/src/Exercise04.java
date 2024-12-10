import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {

        RuntimeException[] exceptions = {
                new Exception1("Неверный формат."),
                new Exception2("Нет доступа к файлу."),
                new Exception3("Надостаточно пямяти."),
                new Exception4("Ресурс не доступен."),
                new Exception5("Превышено время ожидания."),
                new Exception6("Используемый файл поврежден."),
                new Exception7("Не кооректны настройки."),
                new Exception8("Подключение отсутствует"),
                new Exception9("Буфер не доступен"),
                new Exception10("Запрет деления на 0")
        };

        Scanner scanner = new Scanner(System.in);

        printArray(exceptions);
        System.out.println();

            System.out.println("Введите номер исключения (1-10):");
            int choice = scanner.nextInt();

            throw exceptions[choice - 1];

    }

    public static void printArray(RuntimeException[] exceptions){
        for (int i = 0; i < exceptions.length; i++) {
            System.out.println((i + 1) + ". " + exceptions[i]);
        }


    }
}

class Exception1 extends RuntimeException {
    public Exception1(String message) {
        super(message);
    }
}

class Exception2 extends RuntimeException {
    public Exception2(String message) {
        super(message);
    }
}

class Exception3 extends RuntimeException {
    public Exception3(String message) {
        super(message);
    }
}

class Exception4 extends RuntimeException {
    public Exception4(String message) {
        super(message);
    }
}

class Exception5 extends RuntimeException {
    public Exception5(String message) {
        super(message);
    }
}

class Exception6 extends RuntimeException {
    public Exception6(String message) {
        super(message);
    }
}

class Exception7 extends RuntimeException {
    public Exception7(String message) {
        super(message);
    }
}

class Exception8 extends RuntimeException {
    public Exception8(String message) {
        super(message);
    }
}

class Exception9 extends RuntimeException {
    public Exception9(String message) {
        super(message);
    }
}

class Exception10 extends RuntimeException {
    public Exception10(String message) {
        super(message);
    }
}

