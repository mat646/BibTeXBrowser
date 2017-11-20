package com.oop.bibtex.main;

import java.util.HashSet;
import java.util.Set;

public class BibTeXFile implements BibTeXEntity {

    Set<BibTeXEntity> elements = new HashSet<>();

    public BibTeXFile() {

    }

    @Override
    public void accept(IFileVisitor visitor) {
        for (BibTeXEntity bibTeXEntity : elements) {
            bibTeXEntity.accept(visitor);
        }

        visitor.visit(this);
    }

    public void put(String key, BibTeXEntity bibTeXEntity) {
        elements.add(bibTeXEntity);
    }
}
