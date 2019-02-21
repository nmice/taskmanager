package ru.neginskiy.tm.error;

public class UncorrectSessionException extends RuntimeException {

    public UncorrectSessionException() {
        super("Session is uncorrect");
    }
}
