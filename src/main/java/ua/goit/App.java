package ua.goit;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpStatusChecker statusChecker = new HttpStatusChecker();
        System.out.println(statusChecker.getStatusImage(100));

    }
}
