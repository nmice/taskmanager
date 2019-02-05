package ru.neginskiy.tm.error;

public class UncorrectSessionException extends Exception {

    public UncorrectSessionException() {
        super("Session is uncorrect");
    }
}
