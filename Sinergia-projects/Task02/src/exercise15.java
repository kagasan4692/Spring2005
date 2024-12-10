public class exercise15 {
    public static void main(String[] args) {
        String str1 = "Практика программирования";
        String str2 = "переменные, ветвления, циклы";

//        String str1 = "переменные, ветвления, циклы"; //ПРОВЕРОЧНЫЕ СТРОКИ для второго условия
//        String str2 = "Практика программирования";

        if (str1.length() > str2.length()) {
            System.out.println("Строка1: " + "'" + str1 + "' -" + " длиннее!");
        } else {
            System.out.println("Строка2: " + "'" + str2 + "' -" + " длиннее!");
        }
    }
}
