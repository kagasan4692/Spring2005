public class Exercise03 {
//    Для защиты от NPE нужно использовать явную проверку на null
public static void main(String[] args) {
    String str = null;

    int length = (str != null) ? str.length() : 0;
    System.out.println("Длина строки: " + length);
}
}
