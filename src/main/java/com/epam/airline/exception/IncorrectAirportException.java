package com.epam.airline.exception;

public class IncorrectAirportException extends RuntimeException {
    public IncorrectAirportException(String message) {
        super(message);
    }
}
