public class Exercise01 {

public static void main(String[] args) {
//    Выбросить NPE  можно автоматически:
//    String str = null;
//    System.out.println(str.length());

//    Или можно выбросить явно:
    throw new NullPointerException("Это пример NullPointerException");
}
}
