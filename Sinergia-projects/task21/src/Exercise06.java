public class Exercise06 {
    String task;


    public static void main(String[] args) {
        String string1 = "найти минимум из 2 чисел";
        String string2 = "найти сумму элементов массива";
        String string3 = "вывести строку с конца";

        Exercise06 taskGen = new Exercise06();
        taskGen.taskSelection(string1);
        taskGen.taskSelection(string2);
        taskGen.taskSelection(string3);

    }


    private void taskSelection(String string) {
        this.task = string;

        switch (this.task) {
            case "найти минимум из 2 чисел":
                printMinOfTwoCode(string);
                break;
            case "найти сумму элементов массива":
                printSumArrayElementsCode(string);
                break;
            case "вывести строку с конца":
                printReverseStringCode(string);
                break;
        }
    }

    private void printMinOfTwoCode(String string) {
        System.out.println(string + " :");
        System.out.println(" ");

        System.out.println("    public static void minOfTwo() {");
        System.out.println("        int a = 5, b = 10;");
        System.out.println("        int min = (a < b) ? a : b;");
        System.out.println("        System.out.println(\"Минимум: \" + min);");
        System.out.println("    }");
        System.out.println(" ");

        System.out.println("Выполняем Этот код :");
        minOfTwo();
        System.out.println("_______________________");
        System.out.println(" ");
    }

    private void printSumArrayElementsCode(String string) {
        System.out.println(string + " :");
        System.out.println(" ");

        System.out.println("    public static void sumArrayElements() {");
        System.out.println("        int[] array = {1, 2, 3, 4, 5};");
        System.out.println("        int sum = 0;");
        System.out.println("        for (int i = 0; i < array.length; i++) {");
        System.out.println("            sum = sum + array[i];");
        System.out.println("        }");
        System.out.println("        System.out.println(\"Сумма элементов: \" + sum);");
        System.out.println("    }");
        System.out.println(" ");

        System.out.println("Выполняем Этот код :");
        sumArrayElements();
        System.out.println("_______________________");
        System.out.println(" ");
    }

    private void printReverseStringCode(String string) {
        System.out.println(string + " :");
        System.out.println(" ");

        System.out.println("    public static void ReverseString(String string) {");
        System.out.println("        String reversed = new StringBuilder(string).reverse().toString();");
        System.out.println("        System.out.println(\"Перевернутая строка: \" + reversed);");
        System.out.println("    }");
        System.out.println(" ");

        System.out.println("Выполняем Этот код :");
        ReverseString(string);
        System.out.println("_______________________");
        System.out.println(" ");
    }

    public static void minOfTwo() {
        int a = 5, b = 10;
        int min = (a < b) ? a : b;
        System.out.println("Минимум: " + min);
    }

    public static void sumArrayElements() {
        int[] array = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        System.out.println("Сумма элементов: " + sum);
    }

    public static void ReverseString(String string) {
        String reversed = new StringBuilder(string).reverse().toString();
        System.out.println("Перевернутая строка: " + reversed);
    }

}
