package ua.goit;

import lombok.Data;
import ua.goit.exceptions.PageNotFoundException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Data
public class HttpStatusChecker {
    //private static final HttpClient CLIENT = HttpClient.newHttpClient();
    static final String BASE_URL = "https://http.cat/";

    public String getStatusImage(int code) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + code))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        HttpStatusChecker checker = new HttpStatusChecker();

        try {
            checker.validateResponseCode(code, response.statusCode());
        } catch (PageNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        String url = String.format("%s%d.jpg", BASE_URL, code);

        return url;
    }

    public void validateResponseCode(int pageId, int responseCode) throws PageNotFoundException {
        if (responseCode == 404) {
            throw new PageNotFoundException("Page with pageId = " + pageId + " does not exist!");
        }
    }
}

