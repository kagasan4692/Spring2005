import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class point01 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер месяца : ");
        int enteredMonth = scanner.nextInt();

        System.out.println("Введите год в формате YYYY: ");
        int enteredYear = scanner.nextInt();

        for (int i = 1; i < 32; i++) {
            String[] mediaContentNasa = pictureLinkNasaRequest(dateForRequest(i, enteredMonth, enteredYear));

            String date = mediaContentNasa[0];
            String mediaType = mediaContentNasa[1];
            String comment = mediaContentNasa[2];
            String link = mediaContentNasa[3];

            if (!date.equals("no page")) {
                if (mediaType.equals("image")) {
                    System.out.println("сохраняем картинку № : " + i);
                    saveImageToFile(link, i);
                    System.out.println("сохраняем описание");
                    saveTextToFile(comment, i, date);

                } else if (mediaType.equals("video")) {
                    System.out.println(link);
                }
            }

        }

    }

    private static void saveTextToFile(String text, int index, String date) throws IOException {
        File file = new File("nasa_pictures/" + index + ".txt");
        text = date + " : " + text;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(text);
        }
    }

    private static void saveImageToFile(String linkToPicture, int index) throws IOException {
        try (InputStream in = new URL(linkToPicture).openStream()) {
            Files.copy(in, Path.of("nasa_pictures/" + index + typeFile(linkToPicture)));

        }
    }

    private static String typeFile(String linkToPicture) {
        String tailLink = linkToPicture.substring(22);
        int typeFileStart = tailLink.lastIndexOf('.');

        return tailLink.substring(typeFileStart);
    }

    private static String dateForRequest(int day, int month, int year) {

        return year + "-" + month + "-" + day;
    }

    private static String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    }

    private static String[] pictureLinkNasaRequest(String date) throws IOException {
        String key = "D6q5GOfTwbkkYfdnHZXgmRoIlNstZxbyxqUkHDBh";

        String page;
        String[] newArray = new String[4];

        try {
            page = downloadWebPage("https://api.nasa.gov/planetary/apod?&date=" + date + "&api_key=" + key);

            int quoteMediaTypeStart = page.lastIndexOf("media_type") + 13;
            int quoteMediaTypeEnd = page.lastIndexOf("service_version") - 3;
            String mediaType = page.substring(quoteMediaTypeStart, quoteMediaTypeEnd);

            int quoteStart = page.lastIndexOf("url") + 6;
            int quoteEnd = page.lastIndexOf("}") - 1;
            String link = page.substring(quoteStart, quoteEnd);

            String comment = "";
            if (mediaType.equals("image")) {
                int quoteCommentStart = page.lastIndexOf("explanation") + 14;
                int quoteCommentEnd = page.lastIndexOf("hdurl") - 3;

                comment = page.substring(quoteCommentStart, quoteCommentEnd);
            } else if (mediaType.equals("video")) {

                int quoteCommentStart = page.lastIndexOf("explanation") + 14;
                int quoteCommentEnd = page.lastIndexOf("media_type") - 3;

                comment = page.substring(quoteCommentStart, quoteCommentEnd);
            }


            int quoteDateStart = page.lastIndexOf("date") + 7;
            int quoteDateEnd = page.lastIndexOf("explanation") - 3;
            String pageDate = page.substring(quoteDateStart, quoteDateEnd);

            newArray[0] = pageDate;
            newArray[1] = mediaType;
            newArray[2] = comment;
            newArray[3] = link;

        } catch (Exception e) {

            newArray[0] = "no page";

        }
        ;

        return newArray;
    }
}
