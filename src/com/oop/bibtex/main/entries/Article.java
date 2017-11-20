package com.oop.bibtex.main.entries;

import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.Entry;
import com.oop.bibtex.main.IFileVisitor;
import static com.oop.bibtex.main.Attributes.*;
import java.util.Map;

public class Article extends Entry {

    public static final Attributes[] requiredFields = {AUTHOR, TITLE, JOURNAL, YEAR};
    public static final Attributes[] optionalFields = {VOLUME, NUMBER, PAGES, MONTH, NOTE, KEY};

    public Article(Map<Attributes, String> records) {
        super(records);
    }

    @Override
    public void accept(IFileVisitor visitor) {
        visitor.visit(this);
    }
}
