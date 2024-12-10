import java.io.IOException;

public class exercise03 {
    public static void main(String[] args) throws IOException {
        System.out.println("введите латинскими буквами не менее двух слов. Первое слово не более 10 букв!");

        String string = "";
        int i = 0;
        while (i < 10) {
            i++;
            int integer = System.in.read();
            if (integer == 32) {
                i = 10;
            } else {
                char symbol = (char) integer;
                string = string + symbol;
            }

        }

        System.out.println("Слово до пробела:");
        System.out.println(string);


    }
}
