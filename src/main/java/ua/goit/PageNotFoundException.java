package ua.goit;

public class PageNotFoundException extends Exception {
    public PageNotFoundException(String message) {
        super(message);
    }
}
