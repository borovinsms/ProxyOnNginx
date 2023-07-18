package ru.netology.proxyonnginx.exception;

public class InvalidCredentials extends RuntimeException{

    public InvalidCredentials(String message) {
        super(message);
    }
}
