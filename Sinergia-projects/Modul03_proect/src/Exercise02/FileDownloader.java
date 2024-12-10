package Exercise02;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileDownloader {
    public static void saveMedia(String[] trekData){
        String fileUrl = trekData[2];

        String savePath = "src/Exercise02/treks/" + trekData[0] + "_" + trekData[1] + "_" + getCurrentDateTimeAsString() + typeFile(fileUrl);

        System.out.println("Сохраняем...");
        try(
                InputStream in = new URL(fileUrl).openStream();
                FileOutputStream out = new FileOutputStream(savePath))

        {
            in.transferTo(out);
            System.out.println("Файл успешно скачан: " + savePath);
            System.out.println("Чтобы воспроизвести этот файл нажмите на ссылку:");
            System.out.println(fileUrl);
        } catch(
                Exception e)

        {
            System.err.println("Ошибка при скачивании файла: " + e.getMessage());
        }
    }

    public static String getCurrentDateTimeAsString() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

        return now.format(formatter);
    }

    private static String typeFile(String linkToPicture) {
        String tailLink = linkToPicture.substring(22);
        int typeFileStart = tailLink.lastIndexOf('.');

        return tailLink.substring(typeFileStart);
    }

}
