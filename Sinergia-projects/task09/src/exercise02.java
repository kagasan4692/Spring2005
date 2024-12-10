import java.io.IOException;

public class exercise02 {
    public static void main(String[] args) throws IOException {
        System.out.println("введите любое слово латинскими буквами (не менее 5 букв)");

        String string = "";
        int i = 0;
        while (i < 5) {
            i++;
            char symbol = (char) System.in.read();
            string = string + symbol;
        }

        System.out.println("Слово из 5 первых букв:");
        System.out.println(string);

    }
}