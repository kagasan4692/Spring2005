public class Exercise02 implements NewsFetcher {
    public static void main(String[] args) {
        Exercise02 app = new Exercise02();
        String keyword = "science";

        System.out.println("Запрос новостей для категории: " + keyword);
        String response = app.fetchNews(keyword);

        System.out.println("\nРезультат запроса (JSON):");
        System.out.println(response);
    }
}
