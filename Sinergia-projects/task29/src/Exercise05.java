public class Exercise05 {
    public static void main(String[] args) {
        // 1. Конструктор по умолчанию
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Создан объект по умолчанию.");
        System.out.println("sb1: " + sb1);

        // 2. Конструктор с начальной ёмкостью
        StringBuilder sb2 = new StringBuilder(50);
        sb2.append("Создан объект с начальной ёмкостью 50.");
        System.out.println("sb2: " + sb2);
        System.out.println("Емкость sb2: " + sb2.capacity());

        // 3. Конструктор с начальной строкой
        StringBuilder sb3 = new StringBuilder("Конструктор LEGO!");
        System.out.println("sb3: " + sb3);
        System.out.println("Длина sb3: " + sb3.length());
        System.out.println("Емкость sb3: " + sb3.capacity());
    }
}
