package ru.netology.cloud_storage.exeption;

public class PasswordIncorrect extends RuntimeException {
    public PasswordIncorrect(String message) {
        super(message);
    }
}
