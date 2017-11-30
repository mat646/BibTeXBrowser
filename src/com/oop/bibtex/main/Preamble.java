package com.oop.bibtex.main;

import com.oop.bibtex.main.visitors.IFileVisitor;

public class Preamble implements BibTeXEntity {
    @Override
    public void accept(IFileVisitor visitor) {
        visitor.visit(this);
    }
}
