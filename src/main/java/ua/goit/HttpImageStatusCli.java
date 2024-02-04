package ua.goit;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {

    void askStatus() throws IOException, InterruptedException {
        int inputCode = -1;
        boolean continueInput = true;
        Scanner scanner = new Scanner(System.in);
        HttpStatusChecker statusChecker = new HttpStatusChecker();
        HttpStatusImageDownloader statusImageDownloader = new HttpStatusImageDownloader();

        do {
            try {
                System.out.print("Enter HTTP status code: ");
                inputCode = scanner.nextInt();
                continueInput = false;
            } catch (InputMismatchException ex) {
                System.out.println("Please enter valid number");
                scanner.nextLine();
            }
            if (statusChecker.getStatusImage(inputCode) == null) {
                System.out.println("There is not image for HTTP status " + inputCode);
                continueInput = true;
            } else {
                statusImageDownloader.downloadStatusImage(inputCode);
            }
        } while (continueInput);
    }
}
