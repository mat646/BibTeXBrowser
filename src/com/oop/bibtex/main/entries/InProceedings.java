package com.oop.bibtex.main.entries;

import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.Entry;
import com.oop.bibtex.main.IFileVisitor;
import static com.oop.bibtex.main.Attributes.*;

import java.util.Map;

public class InProceedings extends Entry {

    public static final Attributes[] requiredFields = {AUTHOR, TITLE, BOOKTITLE, YEAR};
    public static final Attributes[] optionalFields = {EDITOR, VOLUME, NUMBER, SERIES, PAGES, ADDRESS, MONTH, ORGANIZATION, PUBLISHER, NOTE, KEY};

    public InProceedings(Map<Attributes, String> records, String key) {
        super(records,key);
    }

    @Override
    public void accept(IFileVisitor visitor) {
        visitor.visit(this);
    }
}
