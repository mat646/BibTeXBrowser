package com.oop.bibtex.main;

public class Preamble implements BibTeXEntity {
    @Override
    public void accept(IFileVisitor visitor) {
        visitor.visit(this);
    }
}
