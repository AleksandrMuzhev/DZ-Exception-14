package ru.netology;

public class AlreadyExistsException extends Throwable {
    public AlreadyExistsException(String s) {
        super(s);
    }
}
