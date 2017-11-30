package com.oop.bibtex.main.exceptions;

public class IncompleteOptionsException extends Exception {

    /**
     * IncompleteOptionsException is frown when user runs parser without necessary execution options.
     * @param details passes type of lacking options.
     */
    public IncompleteOptionsException(String details) {
        super(details);
    }

}
