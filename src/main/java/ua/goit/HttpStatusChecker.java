package ua.goit;

import lombok.Data;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Data
public class HttpStatusChecker {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final String BASE_URL = "https://http.cat/";

    public String getStatusImage(int code) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + code))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        HttpStatusChecker checker = new HttpStatusChecker();

        try {
            checker.validateResponseCode(code, response.statusCode());
        } catch (PageNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        return String.format("%s%d.jpg", BASE_URL, code);
    }
    public void validateResponseCode(int id, int code) throws PageNotFoundException {
        if (id == 404) {
            throw new PageNotFoundException("Page with id = " + code + "does not exist!");
        }
    }
}
