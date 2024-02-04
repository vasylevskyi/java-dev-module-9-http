package ua.goit;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpStatusChecker statusChecker = new HttpStatusChecker();
        HttpStatusImageDownloader statusImageDownloader = new HttpStatusImageDownloader();
        HttpImageStatusCli imageStatusCli = new HttpImageStatusCli();

        //Task 1.

        //String url = statusChecker.getStatusImage(-1);
        //System.out.println(url);

        // Task 2.

        //statusImageDownloader.downloadStatusImage(300);

        // Task 3.

        imageStatusCli.askStatus();

    }
}
