package com.oop.bibtex.main.entries;

import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.Entry;
import com.oop.bibtex.main.IFileVisitor;

import java.util.Map;

public class InCollection extends Entry {

    public static final String[] requiredFields = {};
    public static final String[] optionalFields = {};

    public InCollection(Map<Attributes, String> records) {
        super(records);
    }

    @Override
    public void accept(IFileVisitor visitor) {
        visitor.visit(this);
    }
}
