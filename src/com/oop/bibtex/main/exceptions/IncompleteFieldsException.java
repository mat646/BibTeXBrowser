package com.oop.bibtex.main.exceptions;

public class IncompleteFieldsException extends Exception {

    public String details;

    public IncompleteFieldsException(String details) {
        this.details = details;
    }

}
