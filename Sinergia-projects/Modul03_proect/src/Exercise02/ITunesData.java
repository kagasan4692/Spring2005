package Exercise02;

import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ITunesData {
    private static final String iTunesUrl = "https://itunes.apple.com/search";
    private static final int tracks = 500;

    public static String[][] getITunesData(String quote) throws IOException {
        String stringArray = getITunesJson(iTunesUrl, quote);

        String[][] playlist = new String[tracks][3];
        if (stringArray.equals("Не найдено!")) {
            System.exit(0);
        } else {
            playlist = getDataMedia(stringArray);
        }
        return playlist;
    }

    public static String[][] getDataMedia(String stringArray) throws IOException {
        String element;
        String[] array;
        String[][] playlist = new String[tracks][3];
        boolean isTrack = true;

        int i = 0;
        do {
            i++;
            try {
                array = getElementArray(stringArray);
                stringArray = array[0];
                element = array[1];
                playlist[i - 1] = getElementMedia(element);
            } catch (Exception e) {
                isTrack = false;
            }


        } while (isTrack);

        return playlist;
    }

    public static String[] getElementMedia(String element) throws IOException {
        String artist;
        String name;
        String link;

        int artistStart = element.lastIndexOf("artistName") + 13;
        int artistEnd = element.lastIndexOf("collectionName") - 4;

        try {
            artist = element.substring(artistStart, artistEnd);
        } catch (Exception e) {
            artist = "Нет данных";
        }


        int nameStart = element.lastIndexOf("collectionCensoredName") + 25;
        int nameEnd = element.lastIndexOf("trackCensoredName") - 4;

        try {
            name = element.substring(nameStart, nameEnd);
        } catch (Exception e) {
            name = "Нет данных";
        }


        int linkStart = element.lastIndexOf("previewUrl") + 13;
        int linkEnd = element.lastIndexOf("artworkUrl30") - 4;

        try {
            link = element.substring(linkStart, linkEnd);
        } catch (Exception e) {
            link = "Нет данных";
        }

        String[] array = {artist, name, link};

        return array;
    }

    public static String getITunesJson(String iTunesUrl, String query) throws IOException {
        String url = iTunesUrl + "?term=" + query.replace(" ", "+") + "&limit=" + tracks;
        String page = downloadWebPage(url);

        String arrayJson;
        int quoteStart = page.lastIndexOf("[") + 1;
        int quoteEnd = page.lastIndexOf("]");

        if (quoteStart != quoteEnd) {
            arrayJson = page.substring(quoteStart, quoteEnd);
        } else {
            arrayJson = "Не найдено!";
        }


        return arrayJson;
    }

    public static String[] getElementArray(String arrayString) {

        int quoteStart = arrayString.lastIndexOf("{");
        int quoteEnd = arrayString.lastIndexOf("}") + 1;
        String elementJson = arrayString.substring(quoteStart, quoteEnd);

        String newArrayString = arrayString.substring(0, quoteStart) + arrayString.substring(quoteEnd);

        String[] newArray = {newArrayString, elementJson};

        return newArray;
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
}
