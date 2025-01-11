package exercise02;

public class Run implements NewsFetcher {
    public static void main(String[] args) {
        Run app = new Run();
        String keyword = "science";

        System.out.println("Запрос новостей для категории: " + keyword);
        String response = app.fetchNews(keyword);

        System.out.println("\nРезультат запроса (JSON):");
        System.out.println(response);
    }
}
