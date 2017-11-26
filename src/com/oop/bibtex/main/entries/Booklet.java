package com.oop.bibtex.main.entries;

import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.Entry;
import com.oop.bibtex.main.IFileVisitor;
import static com.oop.bibtex.main.Attributes.*;

import java.util.Map;

public class Booklet extends Entry {

    public static final Attributes[] requiredFields = {TITLE};
    public static final Attributes[] optionalFields = {AUTHOR, HOWPUBLISHED, ADDRESS, MONTH, YEAR, NOTE, KEY};

    public Booklet(Map<Attributes, String> records) {
        super(records);
    }

    @Override
    public void accept(IFileVisitor visitor) {
        visitor.visit(this);
    }
}
