package com.oop.bibtex.main.exceptions;

public class IncompleteFieldsException extends Exception {

    /**
     * IncompleteFieldsException is frown when user attempts to factory entry that lacks in required field.
     * @param details passes type of entry that user tried to factory.
     *
     */
    public IncompleteFieldsException(String details) {
        super(details);
    }

}
