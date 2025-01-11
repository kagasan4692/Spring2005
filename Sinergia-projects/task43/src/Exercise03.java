public class Exercise03 implements NewsFetcher {
//  Поскольку указанный в задании API в данный момент возвращает ответ, что сервис временно не доступен,
//  я использовал другой новостной API.
    public static void main(String[] args) {
        Exercise03 app = new Exercise03();

        String[] categories = {"science", "business", "sports", "world", "technology", "automobile"};

        for (int i = 0; i < categories.length; i++) {
            System.out.println("Запрос новостей для категории: " + categories[i]);
            String response = app.fetchNews(categories[i]);

            System.out.println("\nРезультат запроса (JSON):");
            System.out.println(response);
        }
    }
}
