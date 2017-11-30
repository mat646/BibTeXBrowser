package com.oop.bibtex.main;

import com.oop.bibtex.main.visitors.IFileVisitor;

public interface BibTeXEntity {

    /**
     *
     * @param visitor that visits all files components
     */
    void accept(IFileVisitor visitor);

}
