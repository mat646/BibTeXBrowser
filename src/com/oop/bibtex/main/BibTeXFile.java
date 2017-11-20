package com.oop.bibtex.main;

import java.util.HashMap;
import java.util.Map;

public class BibTeXFile implements BibTeXEntity {

    Map<String, BibTeXEntity> elements = new HashMap<>();

    public BibTeXFile() {

    }

    @Override
    public void accept(IFileVisitor visitor) {
        for (BibTeXEntity bibTeXEntity : elements.values()) {
            bibTeXEntity.accept(visitor);
        }

        visitor.visit(this);
    }

    public void put(String key, BibTeXEntity bibTeXEntity) {
        elements.put(key, bibTeXEntity);
    }
}
