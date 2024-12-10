import java.io.IOException;
import java.util.Random;

public class Exercise06 {
    public static void main(String[] args) throws Exception {
            throw getRandomException();

    }

    public static Exception getRandomException() {
        Exception[] exceptions = {
                new InvalidFormatExceptions("Ошибка: Неверный формат данных"),
                new FileUnavailableExceptions("Ошибка: Файл недоступен"),
                new MemoryOverflowExceptions("Ошибка: Переполнение памяти"),
                new ResourceNotFoundExceptions("Ошибка: Ресурс не найден"),
                new TimeoutExceededExceptions("Ошибка: Превышено время ожидания"),
                new IncorrectPasswordExceptions("Ошибка: Неправильный пароль"),
                new CorruptedFileExceptions("Ошибка: Файл поврежден"),
                new InvalidConfigurationExceptions("Ошибка: Неверная конфигурация"),
                new NoConnectionExceptions("Ошибка: Подключение отсутствует"),
                new BufferUnavailableExceptions("Ошибка: Буфер недоступен")
        };

        Random random = new Random();
        int randomIndex = random.nextInt(exceptions.length);
        return  exceptions[randomIndex];
    }
}

class InvalidFormatExceptions extends Exception {
    public InvalidFormatExceptions(String message) {
        super(message);
    }
}

class FileUnavailableExceptions extends Exception {
    public FileUnavailableExceptions(String message) {
        super(message);
    }
}

class MemoryOverflowExceptions extends Exception {
    public MemoryOverflowExceptions(String message) {
        super(message);
    }
}

class ResourceNotFoundExceptions extends Exception {
    public ResourceNotFoundExceptions(String message) {
        super(message);
    }
}

class TimeoutExceededExceptions extends Exception {
    public TimeoutExceededExceptions(String message) {
        super(message);
    }
}

class IncorrectPasswordExceptions extends Exception {
    public IncorrectPasswordExceptions(String message) {
        super(message);
    }
}

class CorruptedFileExceptions extends Exception {
    public CorruptedFileExceptions(String message) {
        super(message);
    }
}

class InvalidConfigurationExceptions extends Exception {
    public InvalidConfigurationExceptions(String message) {
        super(message);
    }
}

class NoConnectionExceptions extends Exception {
    public NoConnectionExceptions(String message) {
        super(message);
    }
}

class BufferUnavailableExceptions extends Exception {
    public BufferUnavailableExceptions(String message) {
        super(message);
    }
}
