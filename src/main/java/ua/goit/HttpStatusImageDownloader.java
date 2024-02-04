package ua.goit;

import ua.goit.exceptions.PageNotFoundException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpStatusImageDownloader {
    void downloadStatusImage(int code) throws IOException, InterruptedException, PageNotFoundException {
        HttpStatusChecker statusChecker = new HttpStatusChecker();
        
        HttpClient httpClient = HttpClient.newHttpClient();

        String url = statusChecker.getStatusImage(code);

        if (url != null) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(HttpStatusChecker.BASE_URL + code))
                    .GET()
                    .build();

            httpClient.send(request, HttpResponse
                    .BodyHandlers
                    .ofFile(Paths.get(String.format("%d.jpg", code)))
            );
        }
    }
}
