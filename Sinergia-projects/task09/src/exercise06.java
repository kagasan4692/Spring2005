import java.io.IOException;

public class exercise06 {
    public static void main(String[] args) throws IOException {
        System.out.println("введите число, затем слово. Но всего не более 7 символов");

        String string = "";
        int i = 0;
        while (i < 7) {
            i++;
            int symbol = System.in.read();
            if (symbol > 48 && symbol < 57) {
                int number = symbol - 48;
                string = string + number;
            } else if (symbol == 46) {
                char point = (char) symbol;
                string = string + point;
            } else {
                i = 7;
            }
        }

        System.out.println("Только число: ");
        System.out.println(string);
//        System.out.println(Double.parseDouble(string));

    }
}
