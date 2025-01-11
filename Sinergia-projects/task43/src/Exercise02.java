public class Exercise02 implements NewsFetcher {
    public static void main(String[] args) {
        Exercise02 app = new Exercise02();
        String category = "science";

        System.out.println("Запрос новостей для категории: " + category);
        String response = app.fetchNews(category);

        System.out.println("\nРезультат запроса (JSON):");
        System.out.println(response);
    }
}
