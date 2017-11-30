package com.oop.bibtex.main.entries;

import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.Entry;
import com.oop.bibtex.main.visitors.IFileVisitor;
import java.util.Map;
import static com.oop.bibtex.main.Attributes.*;

public class InBook extends Entry {

    public static final Attributes[] requiredFields = {AUTHOR, EDITOR, TITLE, CHAPTER, PAGES, PUBLISHER, YEAR};
    public static final Attributes[] optionalFields = {VOLUME, NUMBER, SERIES, TYPE, ADDRESS, EDITION, MONTH, NOTE, KEY};

    public InBook(Map<Attributes, String> records, String key) {
        super(records, key);
    }

    @Override
    public void accept(IFileVisitor visitor) {
        visitor.visit(this);
    }
}
