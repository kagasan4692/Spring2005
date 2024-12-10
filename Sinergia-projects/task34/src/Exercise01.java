import java.io.FileReader;
import java.io.IOException;

public class Exercise01 {
    //В Java throw и throws имеют разные назначения и используются в разных контекстах!
//    throw : Выбрасывает исключение. Размещается внутри метода. Работает с одним объектом исключения.
//    Используется для фактического выбрасывания исключения.
//    Пример:

    public void divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        System.out.println(a / b);
    }

    //throws : Декларирует исключения.Размещается внутри метода или блока кода. Может декларировать
//    несколько исключений через запятую.
//    сообщает, какие исключения могут быть выброшены методом, чтобы пользователь метода был готов их обработать.
//    Пример:

    public void readFile(String fileName) throws IOException {
        // Здесь может быть выброшено IOException
        FileReader fileReader = new FileReader(fileName);
    }
}
