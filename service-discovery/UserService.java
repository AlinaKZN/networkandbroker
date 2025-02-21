import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StatisticsServiceClient {

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final String serviceUrl = "http://statistics-service:80";

    public String getStatistics() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(serviceUrl + "/api/statistics"))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static void main(String[] args) {
        StatisticsServiceClient client = new StatisticsServiceClient();
        try {
            String statistics = client.getStatistics();
            System.out.println("Statistics: " + statistics);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}