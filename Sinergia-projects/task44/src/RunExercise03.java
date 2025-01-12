public class RunExercise03 {
    public static void main(String[] args) {
        String directoryPath = "songs"; // Путь к папке с файлами песен
        SongLyrics songLyrics = new DirectorySongLyrics(directoryPath);

        String[] songsArray = {"Yesterday", "the Winter", "Honesty", "I Will Always Love You"};

        for (int i = 0; i < songsArray.length; i++) {
            System.out.println(songLyrics.formatLyrics(songLyrics.getLyrics(songsArray[i])));
        }
    }
}
