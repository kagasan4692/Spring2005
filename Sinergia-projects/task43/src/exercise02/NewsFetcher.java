package exercise02;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface NewsFetcher {
    default String fetchNews(String cat) {
        String apiUrl = "https://api.gdeltproject.org/api/v2/doc/doc?query=" + cat + "&mode=artlist&format=json";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            return "Ошибка при выполнении запроса: " + e.getMessage();
        }
    }
}
