package ua.goit;

import lombok.Data;

import java.net.http.HttpClient;

@Data
public class AppHttpClient {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();





}
