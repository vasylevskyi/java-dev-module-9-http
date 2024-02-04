package ua.goit;

import ua.goit.exceptions.PageNotFoundException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {

    void askStatus() throws IOException, InterruptedException {
        int inputCode = -1;
        boolean continueInput = true;
        Scanner scanner = new Scanner(System.in);
        HttpStatusImageDownloader statusImageDownloader = new HttpStatusImageDownloader();

        do {
            try {
                System.out.print("Enter HTTP status code: ");
                inputCode = scanner.nextInt();
                statusImageDownloader.downloadStatusImage(inputCode);
                continueInput = false;
            } catch (InputMismatchException ex) {
                System.out.println("Please enter valid number");
                scanner.nextLine();
            } catch (PageNotFoundException ex) {
                System.out.println("There is not image for HTTP status " + inputCode);
                scanner.nextLine();
            }
        } while (continueInput);
        scanner.close();
    }
}
