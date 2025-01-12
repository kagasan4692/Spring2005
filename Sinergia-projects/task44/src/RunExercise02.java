public class RunExercise02 {
    public static void main(String[] args) {
        String filePath = "songs.txt";
        SongLyrics songLyrics = new FileSongLyrics(filePath);

        String[] songsArray = {"Сибирские морозы", "Анастасия", "Лучший город земли"};

        for (int i = 0; i < songsArray.length; i++) {
            System.out.println(songLyrics.formatLyrics(songLyrics.getLyrics(songsArray[i])));
        }
    }
}
