public class Exercise03 implements NewsFetcher {
    public static void main(String[] args) {
        Exercise03 app = new Exercise03();

        String[] categories = {"science", "business", "sports", "world", "technology", "automobile"};

        for (String category : categories) {
            System.out.println("Запрос новостей для категории: " + category);
            String response = app.fetchNews(category);

            System.out.println("\nРезультат запроса (JSON):");
            System.out.println(response);
        }
    }
}
