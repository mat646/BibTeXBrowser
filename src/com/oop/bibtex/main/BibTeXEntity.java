package com.oop.bibtex.main;

import com.oop.bibtex.main.visitors.IFileVisitor;


/**
 * Basic entity of the project. Can be either:
 * @see BibTeXFile
 * or any kind of "entries" package
 * @see com.oop.bibtex.main.entries
 * which all extend abstract class
 * @see Entry
 */
public interface BibTeXEntity {

    /**
     *
     * @param visitor that visits all files components
     */
    void accept(IFileVisitor visitor);

}
