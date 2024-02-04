package ua.goit;

import lombok.Data;
import ua.goit.exceptions.PageNotFoundException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class HttpStatusChecker {
    static final String BASE_URL = "https://http.cat/";

    public String getStatusImage(int code) throws IOException, InterruptedException, PageNotFoundException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + code))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        validateResponseCode(code, response.statusCode());

        return String.format("%s%d.jpg", BASE_URL, code);
    }

    public void validateResponseCode(int pageId, int responseCode) throws PageNotFoundException {
        if (responseCode == 404) {
            System.out.println("Page with pageId = " + pageId + " does not exist!");
            throw new PageNotFoundException();
        }
    }
}

