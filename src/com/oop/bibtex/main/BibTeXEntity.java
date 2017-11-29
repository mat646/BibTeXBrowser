package com.oop.bibtex.main;

public interface BibTeXEntity {

    /**
     *
     * @param visitor that visits all its components
     */
    void accept(IFileVisitor visitor);

}
