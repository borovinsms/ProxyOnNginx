package ru.netology.proxyonnginx.exception;

public class UnauthorizedUser extends RuntimeException {

    public UnauthorizedUser(String message) {
        super(message);
    }
}
