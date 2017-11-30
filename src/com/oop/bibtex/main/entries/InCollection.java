package com.oop.bibtex.main.entries;

import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.Entry;
import com.oop.bibtex.main.visitors.IFileVisitor;
import static com.oop.bibtex.main.Attributes.*;

import java.util.Map;

public class InCollection extends Entry {

    public static final Attributes[] requiredFields = {AUTHOR, TITLE, BOOKTITLE, PUBLISHER, YEAR};
    public static final Attributes[] optionalFields = {EDITOR, VOLUME, NUMBER, SERIES, TYPE, CHAPTER, PAGES, ADDRESS, EDITION, MONTH, NOTE, KEY};

    public InCollection(Map<Attributes, String> records, String key) {
        super(records, key);
    }

    @Override
    public void accept(IFileVisitor visitor) {
        visitor.visit(this);
    }
}
