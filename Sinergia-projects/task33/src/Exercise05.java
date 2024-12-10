import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args) {

        RuntimeException[][] exceptions = {
                {
                        new InvalidFormatException("Неверный формат."),
                        new FileAccessException("Нет доступа к файлу."),
                        new MemoryOverflowException("Надостаточно пямяти."),
                },
                {
                        new ResourceNotFoundException("Ресурс не доступен."),
                        new TimeoutExceededException("Превышено время ожидания."),
                        new CorruptedFileException("Используемый файл поврежден."),
                },
                {
                        new IncorrectPasswordException("Не корректен пароль."),
                        new NoConnectionException("Подключение отсутствует"),
                        new BufferAccessException("Буфер не доступен"),
                },

        };

        RuntimeException defaultException = new RowColumnInputException("Не верный ввод № Строки или № Столбца");

        Scanner scanner = new Scanner(System.in);

        printingTwoDimensionalArray(exceptions);

        System.out.println();

        System.out.print("Введите номер строки (1-3): ");
        int row = scanner.nextInt();

        System.out.print("Введите номер столбца (1-3): ");
        int column = scanner.nextInt();

        System.out.println();

        if (row >= 1 && row <= 3 && column >= 1 && column <= 3) {
            throw exceptions[row - 1][column - 1];
        } else {
            throw defaultException;
        }

    }

    private static void printingTwoDimensionalArray(RuntimeException[][] filesArray) {
        for (int i = 0; i < filesArray.length; i++) {
            System.out.println("СТРОКА № " + (i + 1) + " :");
            for (int j = 0; j < filesArray[i].length; j++) {
                System.out.println(" СТОЛБЕЦ № " + (j + 1) + ". " + filesArray[i][j]);
            }
            System.out.println("---------------------");
        }
    }
}

class InvalidFormatException extends RuntimeException {
    public InvalidFormatException(String message) {
        super(message);
    }
}

class FileAccessException extends RuntimeException {
    public FileAccessException(String message) {
        super(message);
    }
}

class MemoryOverflowException extends RuntimeException {
    public MemoryOverflowException(String message) {
        super(message);
    }
}

class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

class TimeoutExceededException extends RuntimeException {
    public TimeoutExceededException(String message) {
        super(message);
    }
}

class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException(String message) {
        super(message);
    }
}

class CorruptedFileException extends RuntimeException {
    public CorruptedFileException(String message) {
        super(message);
    }
}

class NoConnectionException extends RuntimeException {
    public NoConnectionException(String message) {
        super(message);
    }
}

class BufferAccessException extends RuntimeException {
    public BufferAccessException(String message) {
        super(message);
    }
}

class RowColumnInputException extends RuntimeException {
    public RowColumnInputException(String message) {
        super(message);
    }
}