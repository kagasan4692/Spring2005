import java.io.FileReader;
import java.io.IOException;

public class Exercise01 {
//    Checked исключения:
//
//    Checked исключения небходимо либо обработатьс помощью try-catch, либо объявить в сигнатуре метода при помощи throws.
//    Поскольку этого требует компилятор!
//
//    Checked исключения используются когда проблема зависит от внешних факторов (файлы, сеть, база данных) и может быть
//    предсказана.
//
//    Примеры:
//    IOException
//    SQLException
//    FileNotFoundException

public void readFile(String fileName) throws IOException {
    FileReader file = new FileReader(fileName); // Может выбросить IOException
}
//    Unchecked исключения:
//
//    Эти исключения не проверяются компилятором.
//
//    Unchecked исключения чаще всего они возникают из-за ошибок в логике программы (например деление на 0).
//
//    Unchecked исключения используются проблема связана с ошибкой логики программы, и её нельзя исправить на уровне кода
//    (например, ошибка в алгоритме).
//
//    Примеры:
//    RuntimeException
//    NullPointerException
//    ArrayIndexOutOfBoundsException
//    ArithmeticException
//
//    Нет необходимости объявлять throws для unchecked исключений.

public void divide(int a, int b) {
    int result = a / b; // Может выбросить ArithmeticException
}

}
