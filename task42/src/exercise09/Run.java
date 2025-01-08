package exercise09;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Run {
    public static void main(String[] args) {
        try {
            String jsonResponse1 = NasaApiClient.getPictureOfTheDayJson();
            NasaPictureInfo pictureInfo1 = NasaApiClient.parsePictureOfTheDay(jsonResponse1);

            String jsonResponse2 = NasaApiClient.getPictureOfTheDayJson();
            NasaPictureInfo pictureInfo2 = NasaApiClient.parsePictureOfTheDay(jsonResponse2);

            boolean bool1 = false;
            if (pictureInfo1.getMediaType().equals("image")) {
                String savePath = getNameFile();
                pictureInfo1.downloadImage(savePath);
                bool1 = true;
            } else {
                System.out.println("Файл не является изображением. Пропуск загрузки.");
            }

            boolean bool2 = false;
            if (pictureInfo2.getMediaType().equals("image")) {
                String savePath = getNameFile();
                pictureInfo2.downloadImage(savePath);
                bool2 = true;
            } else {
                System.out.println("Файл не является изображением. Пропуск загрузки.");
            }

            if (bool1 && bool2) {
                System.out.println();
                System.out.println("=== Астрономическая фотография №1 ===");
                System.out.println(pictureInfo1);

                System.out.println("=== Астрономическая фотография №2 ===");
                System.out.println(pictureInfo2);

                boolean bool = pictureInfo1.equals(pictureInfo2);
                System.out.println("Совпадение фотографий: " + bool);
            }

        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }


    }

    private static String getNameFile(){
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        String formattedDateTime = now.format(formatter);

        return "nasa_pictures/nasa_picture" + formattedDateTime + ".jpg";
    }
}
