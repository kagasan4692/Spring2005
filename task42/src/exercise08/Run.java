package exercise08;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        try {
            int limit = 5; // от 1 до 10

            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите исполнителя: ");
            String artist = scanner.nextLine();

            ITunesProduct[] randomTracks1 = iTunes.searchTracksByArtist(artist, limit);
            String[] firstArray = new String[limit];
            for (int i = 0; i < randomTracks1.length; i++) {
                firstArray[i] = randomTracks1[i].toString();
            }

            System.out.print("Повторный поиск! Введите исполнителя: ");
            artist = scanner.nextLine();

            System.out.println("\n=== Поиск треков исполнителей ===");

            ITunesProduct[] randomTracks2 = iTunes.searchTracksByArtist(artist, limit);
            String[] secondArray = new String[limit];
            for (int i = 0; i < randomTracks2.length; i++) {
                secondArray[i] = randomTracks2[i].toString();
            }

            ArrayMerger arrayMerger = new ArrayMerger();
            String[] result = arrayMerger.mergeWithoutDuplicates(firstArray, secondArray);

            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }

        } catch (Exception e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
        }
    }

    public static class ArrayMerger {

        public static String[] mergeWithoutDuplicates(String[] array1, String[] array2) {
            String[] tempArray = new String[array1.length + array2.length];
            int index = 0;

            for (int i = 0; i < array1.length; i++) {
                if (!contains(tempArray, array1[i], index)) {
                    tempArray[index++] = array1[i];
                }
            }

            for (int i = 0; i < array2.length; i++) {
                if (!contains(tempArray, array2[i], index)) {
                    tempArray[index++] = array2[i];
                }
            }

            String[] mergedArray = new String[index];
            for (int i = 0; i < index; i++) {
                mergedArray[i] = tempArray[i];
            }

            return mergedArray;
        }

        private static boolean contains(String[] array, String value, int length) {
            for (int i = 0; i < length; i++) {
                if (array[i] != null && array[i].equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }
}
