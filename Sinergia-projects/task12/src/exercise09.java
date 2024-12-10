import java.io.*;

public class exercise09 {
    public static void main(String[] args) throws IOException {

        PrintWriter printWriter = new PrintWriter("list.html");

        printWriter.println("<ul>");

        for (int i = 1; i <= 100; i++) {
            printWriter.println("<li>" + i + " element </li>");
        }

        printWriter.println("</ul>");

        printWriter.close();

        System.out.println("Файл list.html создан");
    }
}
