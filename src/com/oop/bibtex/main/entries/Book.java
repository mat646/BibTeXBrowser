package com.oop.bibtex.main.entries;

import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.Entry;
import com.oop.bibtex.main.IFileVisitor;
import java.util.Map;
import static com.oop.bibtex.main.Attributes.*;

public class Book extends Entry {

    public static final Attributes[] requiredFields = {EDITOR, TITLE, PUBLISHER, YEAR};
    public static final Attributes[] optionalFields = {};

    public Book(Map<Attributes, String> records) {
        super(records);
    }

    @Override
    public void accept(IFileVisitor visitor) {
        visitor.visit(this);
    }
}
