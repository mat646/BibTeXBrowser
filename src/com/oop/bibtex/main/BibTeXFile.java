package com.oop.bibtex.main;

import java.util.HashSet;
import java.util.Set;

public class BibTeXFile implements BibTeXEntity {

    Set<BibTeXEntity> elements = new HashSet<>();

    public BibTeXFile() {

    }


    /**
     *
     * @param visitor that visits all its components in {@code elements} set.
     *                Last visited element is BibTexFile itself to indicate end of file.
     */
    @Override
    public void accept(IFileVisitor visitor) {
        for (BibTeXEntity bibTeXEntity : elements) {
            bibTeXEntity.accept(visitor);
        }

        visitor.visit(this);
    }

    /**
     *
     * @param key associated with value in *.bib
     * @param bibTeXEntity is value from file
     */
    public void put(String key, BibTeXEntity bibTeXEntity) {
        elements.add(bibTeXEntity);
    }
}
