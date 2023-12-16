package ru.netology.cloud_storage.exeption;

public class ErrorStoringFile extends RuntimeException {
    public ErrorStoringFile(String message) {
        super(message);
    }
}
