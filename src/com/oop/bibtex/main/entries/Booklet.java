package com.oop.bibtex.main.entries;

import com.oop.bibtex.main.Entry;
import com.oop.bibtex.main.IFileVisitor;

public class Booklet extends Entry {
    @Override
    public void accept(IFileVisitor visitor) {
        visitor.visit(this);
    }
}
