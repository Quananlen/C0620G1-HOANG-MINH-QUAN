package com.giga.exception;

public class NotAvailableException extends Exception {
    @Override
    public String getMessage() {
        return "Book is not available";
    }
}
