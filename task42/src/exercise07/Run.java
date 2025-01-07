package exercise07;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

        try {
            ITunesProduct track1 = ITunesProduct.getTrackByArtist("Alla Pugacheva");
            System.out.println("\n=== Информация о треке 1 ===");
            System.out.println(track1);

            ITunesProduct track2 = ITunesProduct.getTrackByArtist("Кузьмин");
            System.out.println("\n=== Информация о треке 2 ===");
            System.out.println(track2);

            boolean bool = track1.equals(track2);
            System.out.println("Совпадение по полям artist и name (метод equals()): " + bool);

        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
        }
    }
}
